using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Shapes;
using System.Windows.Media;
using System.Windows.Input;

namespace WPFCanvas
{
    public class VarRectangle
    {
        /// <summary>
        /// 坐标点
        /// </summary>
        private List<Point> points;

        /// <summary>
        /// 画布
        /// </summary>
        private Canvas canvas;

        /// <summary>
        /// 直线
        /// </summary>
        private List<Line> lines=null;

        /// <summary>
        /// 定位点
        /// </summary>
        private List<AnchorPoint> anchorPoints = null;

        /// <summary>
        /// 是否鼠标为按下
        /// </summary>
        private bool isMouseDown = false;

        /// <summary>
        /// 当前选中定位点
        /// </summary>
        private AnchorPoint curAnchorPoint = null;

        public VarRectangle(Canvas canvas, List<Point> points) 
        {
            this.canvas = canvas;
            this.points = points;
            lines = new List<Line>();
            anchorPoints = new List<AnchorPoint>();
        }

        public List<Line> Lines
        {
            get 
            {
                return lines;
            }
        }

        public void init()
        {
            //按x轴分类
            IEnumerable<IGrouping<double, Point>> pointXs = points.GroupBy(o => o.X);
            //按y周分类
            IEnumerable<IGrouping<double, Point>> pointYs = points.GroupBy(o => o.Y);
            //绘制竖线
            drawXLine(pointXs);
            //绘制横线
            drawYLine(pointYs);
            //设置定位点
            addAnchorPoints();
            //绘制定位点并且添加事件
            foreach (AnchorPoint anchorPoint in anchorPoints)
            {
                Rectangle rec=anchorPoint.draw();
                rec.MouseLeftButtonDown += new MouseButtonEventHandler(rec_MouseLeftButtonDown);
                rec.MouseMove += new MouseEventHandler(rec_MouseMove);
                canvas.Children.Add(rec);
            }
            canvas.MouseLeftButtonUp += new MouseButtonEventHandler(canvas_MouseLeftButtonUp);
            canvas.MouseMove += new MouseEventHandler(canvas_MouseMove);
            canvas.MouseLeave += new MouseEventHandler(canvas_MouseLeave);
        }

        void canvas_MouseLeave(object sender, MouseEventArgs e)
        {
            isMouseDown = false;
        }

        void rec_MouseMove(object sender, MouseEventArgs e)
        {
            if (!isMouseDown)
            {
                Rectangle rec = (Rectangle)sender;
                AnchorPoint anchorPoint = anchorPoints.Where(o => o.Key == rec.DataContext.ToString()).Single();
                Mouse.SetCursor(anchorPoint.Cursor);
            }
        }

        void canvas_MouseMove(object sender, MouseEventArgs e)
        {
            if (isMouseDown)
            {
                Point point = e.GetPosition(canvas);
                Mouse.SetCursor(curAnchorPoint.Cursor);
                double curX, curY;
                if (Cursors.SizeNS == curAnchorPoint.Cursor)
                {
                    curX = curAnchorPoint.X;
                    curY = point.Y;
                    moveLines(curX, curY);
                    moveAnchorPoint(curX, curY);
                    curAnchorPoint.move(curX, curY);
                }
                else if (Cursors.SizeWE == curAnchorPoint.Cursor)
                {
                    moveLines(point.X, curAnchorPoint.Y);
                    moveAnchorPoint(point.X, curAnchorPoint.Y);
                    curAnchorPoint.move(point.X, curAnchorPoint.Y);
                }
                else
                {
                    moveLines(point.X,point.Y);
                    moveAnchorPoint(point.X, point.Y);
                    curAnchorPoint.move(point.X, point.Y);
                }
            }
        }
       
        /// <summary>
        /// 移动定位点
        /// </summary>
        /// <returns></returns>
        private void moveAnchorPoint(double x,double y)
        {
            List<AnchorPoint> moveAnchorPoints = new List<AnchorPoint>();
            if (curAnchorPoint.AnchorPointType == AnchorPointType.NS)
            {
                moveAnchorPoints = anchorPoints.Where(o => o.Y == curAnchorPoint.Y ).ToList();
            }
            else if (curAnchorPoint.AnchorPointType == AnchorPointType.WE)
            {
                moveAnchorPoints = anchorPoints.Where(o => o.X == curAnchorPoint.X).ToList();
            }
            else {
                moveAnchorPoints = anchorPoints.Where(o => o.Y == curAnchorPoint.Y || o.X == curAnchorPoint.X).ToList();
            }
            foreach (AnchorPoint anchorPoint in moveAnchorPoints)
            {
                moveAnchorPoint(x, y, anchorPoint);
            }
        }

        /// <summary>
        /// 移动单个点
        /// </summary>
        /// <param name="x"></param>
        /// <param name="y"></param>
        /// <param name="anchorPoint"></param>
        private void moveAnchorPoint(double x, double y, AnchorPoint anchorPoint)
        {
            double preX = anchorPoint.X;
            double preY = anchorPoint.Y;
            if (curAnchorPoint.AnchorPointType == AnchorPointType.NS)
            {
                anchorPoint.move(anchorPoint.X, y);
                moveRefAnchorPoint(preX, preY, anchorPoint);
            }
            else if (curAnchorPoint.AnchorPointType == AnchorPointType.WE)
            {
                anchorPoint.move(x, anchorPoint.Y);
                moveRefAnchorPoint(preX, preY, anchorPoint);
            }
            else
            {
                if (anchorPoint.AnchorPointType == AnchorPointType.NS)
                {
                    anchorPoint.move(anchorPoint.X, y);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
                else if (anchorPoint.AnchorPointType == AnchorPointType.WE)
                {
                    anchorPoint.move(x, anchorPoint.Y);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
                else if (curAnchorPoint.AnchorPointType == AnchorPointType.NE)
                {
                    if (anchorPoint.AnchorPointType == AnchorPointType.SE)
                    {
                        anchorPoint.move(anchorPoint.X, y);
                    }
                    else if (anchorPoint.AnchorPointType == AnchorPointType.NW)
                    {
                        anchorPoint.move(x, anchorPoint.Y);
                    }
                    
                    moveRefAnchorPoint(preX, preY, x, y, anchorPoint);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
                else if (curAnchorPoint.AnchorPointType == AnchorPointType.SW)
                {
                    if (anchorPoint.AnchorPointType == AnchorPointType.SE)
                    {
                        anchorPoint.move(x, anchorPoint.Y);
                    }
                    else if (anchorPoint.AnchorPointType == AnchorPointType.NW)
                    {
                        anchorPoint.move(anchorPoint.X, y);
                    }
                    
                    moveRefAnchorPoint(preX, preY, x, y, anchorPoint);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
                else if (curAnchorPoint.AnchorPointType == AnchorPointType.SE)
                {
                    if (anchorPoint.AnchorPointType == AnchorPointType.SW)
                    {
                        anchorPoint.move(x, anchorPoint.Y);
                    }
                    else if (anchorPoint.AnchorPointType == AnchorPointType.NE)
                    {
                        anchorPoint.move(anchorPoint.X, y);
                    }
                    
                    moveRefAnchorPoint(preX, preY, x, y, anchorPoint);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
                else if (curAnchorPoint.AnchorPointType == AnchorPointType.NW)
                {
                    if (anchorPoint.AnchorPointType == AnchorPointType.SW)
                    {
                        anchorPoint.move(anchorPoint.X, y);
                    }
                    else if (anchorPoint.AnchorPointType == AnchorPointType.NE)
                    {
                        anchorPoint.move(x, anchorPoint.Y);
                    }
                    
                    moveRefAnchorPoint(preX, preY, x, y, anchorPoint);
                    moveRefAnchorPoint(preX, preY, anchorPoint);
                }
            }

        }

        private void moveRefAnchorPoint(double preX, double preY, double x, double y, AnchorPoint movedAnchorPoint)
        {
            foreach (AnchorPoint anchorPoint in anchorPoints)
            {
                if (anchorPoint.RefPoint.Length == 2)
                {
                    Point[] refPoints = anchorPoint.RefPoint;
                    if (refPoints[0].X == preX && refPoints[0].Y == preY
                        && refPoints[1].X == curAnchorPoint.X && refPoints[1].Y == curAnchorPoint.Y)
                    {
                        anchorPoint.RefPoint[0].X = movedAnchorPoint.X;
                        anchorPoint.RefPoint[0].Y = movedAnchorPoint.Y;
                        anchorPoint.RefPoint[1].X = x;
                        anchorPoint.RefPoint[1].Y = y;
                    }
                    if (refPoints[1].X == preX && refPoints[1].Y == preY
                        && refPoints[0].X == curAnchorPoint.X && refPoints[0].Y == curAnchorPoint.Y)
                    {
                        anchorPoint.RefPoint[1].X = movedAnchorPoint.X;
                        anchorPoint.RefPoint[1].Y = movedAnchorPoint.Y;
                        anchorPoint.RefPoint[0].X = x;
                        anchorPoint.RefPoint[0].Y = y;
                    }
                    anchorPoint.X = (anchorPoint.RefPoint[0].X + anchorPoint.RefPoint[1].X) / 2;
                    anchorPoint.Y = (anchorPoint.RefPoint[0].Y + anchorPoint.RefPoint[1].Y) / 2;
                    anchorPoint.move();
                }
            }
        }

        private void moveRefAnchorPoint(double x, double y,AnchorPoint movedAnchorPoint)
        {
            foreach (AnchorPoint anchorPoint in anchorPoints)
            {
                if (anchorPoint.RefPoint.Length == 2)
                {
                    if (anchorPoint.RefPoint[0].X == x && anchorPoint.RefPoint[0].Y == y)
                    {
                        anchorPoint.RefPoint[0].X = movedAnchorPoint.X;
                        anchorPoint.RefPoint[0].Y = movedAnchorPoint.Y;
                    }
                    else if (anchorPoint.RefPoint[1].X == x && anchorPoint.RefPoint[1].Y == y)
                    {
                        anchorPoint.RefPoint[1].X = movedAnchorPoint.X;
                        anchorPoint.RefPoint[1].Y = movedAnchorPoint.Y;
                    }
                    anchorPoint.X = (anchorPoint.RefPoint[0].X + anchorPoint.RefPoint[1].X) / 2;
                    anchorPoint.Y = (anchorPoint.RefPoint[0].Y + anchorPoint.RefPoint[1].Y) / 2;
                    anchorPoint.move();
                }
            }
        }

        private void moveLines(double x, double y)
        {
            List<Line> moveLines = new List<Line>();
            moveLines = lines.Where(o => o.Y1 == curAnchorPoint.Y
                || o.Y2 == curAnchorPoint.Y
                || o.X1 == curAnchorPoint.X
                || o.X2 == curAnchorPoint.X).ToList();
            foreach (Line line in moveLines)
            {
                if (line.Y1 == curAnchorPoint.Y)
                {
                    line.Y1 = y;
                }
                if (line.Y2 == curAnchorPoint.Y)
                {
                    line.Y2 = y;
                }
                if (line.X1 == curAnchorPoint.X)
                {
                    line.X1 = x;
                }
                if (line.X2 == curAnchorPoint.X)
                {
                    line.X2 = x;
                }
            }
        }

        void canvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            isMouseDown = false;
        }

        void rec_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Rectangle rec = (Rectangle)sender;
            AnchorPoint anchorPoint = anchorPoints.Where(o => o.Key == rec.DataContext.ToString()).Single();
            Mouse.SetCursor(anchorPoint.Cursor);
            curAnchorPoint = anchorPoint;
            isMouseDown = true;
        }

        /// <summary>
        /// 绘制竖线
        /// </summary>
        /// <param name="pointYs"></param>
        private void drawYLine(IEnumerable<IGrouping<double, Point>> pointYs)
        {
            foreach (IGrouping<double, Point> pointY in pointYs)
            {
                double x1 = pointY.Max(o => o.X);
                double x2 = pointY.Min(o => o.X);
                drawLine(x1, pointY.Key, x2, pointY.Key);
                if (pointY.Count() == 2)
                {
                    Point[] points=new Point[2];
                    points[0] = new Point(x1, pointY.Key);
                    points[1] = new Point(x2,pointY.Key);
                    anchorPoints.Add(new AnchorPoint((x1 + x2) / 2, pointY.Key, AnchorPointType.NS, points));
                }
                else
                {
                    IEnumerable<Point> pointYOrdereds = pointY.OrderBy(o => o.X);
                    addMiddleAnchorPoints(pointYOrdereds);
                }
            }
        }

        /// <summary>
        /// 绘制横线
        /// </summary>
        /// <param name="pointXs"></param>
        private void drawXLine(IEnumerable<IGrouping<double, Point>> pointXs)
        {
            foreach (IGrouping<double, Point> pointX in pointXs)
            {
                double y1 = pointX.Max(o => o.Y);
                double y2 = pointX.Min(o => o.Y);
                drawLine(pointX.Key,y1,pointX.Key,y2);
                if (pointX.Count() <= 2)
                {
                    Point[] points = new Point[2];
                    points[0] = new Point(pointX.Key,y1);
                    points[1] = new Point(pointX.Key, y2);
                    anchorPoints.Add(new AnchorPoint(pointX.Key, (y1 + y2) / 2, AnchorPointType.WE, points));
                }
                else
                {
                    IEnumerable<Point> pointXOrdereds = pointX.OrderBy(o => o.Y);
                    addMiddleAnchorPoints(pointXOrdereds);
                }
            }
        }

        /// <summary>
        /// 添加定位点
        /// 每个点
        /// </summary>
        private void addAnchorPoints()
        {
            double minX = points.Min(o => o.X);
            double maxX = points.Max(o => o.X);
            double minY = points.Min(o => o.Y);
            double maxY = points.Max(o => o.Y);
            foreach (Point point in points)
            {
                if (point.X == minX && point.Y == minY)
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.SE));
                }
                else if (point.X == maxX && point.Y == maxY)
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.NW));
                }
                else if (point.X == minX && point.Y == maxY)
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.SW));
                }
                else if (point.X == maxX && point.Y == minY)
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.NE));
                }
                else if ((point.X == minX || point.X == maxX) && (point.Y > minY && point.Y < maxY))
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.WE));
                }
                else if ((point.Y == minY || point.Y == maxY) && (point.X > minX && point.X < maxX))
                {
                    anchorPoints.Add(new AnchorPoint(point.X, point.Y, AnchorPointType.NS));
                }
            }
        }

        /// <summary>
        /// 添加线的中点定位点
        /// </summary>
        /// <param name="pointYOrdereds"></param>
        private void addMiddleAnchorPoints(IEnumerable<Point> pointYOrdereds)
        {
            Point[] pointYOrderedArray = pointYOrdereds.ToArray();
            for (int index = 0; index < pointYOrderedArray.Length - 1; index++)
            {
                double x = (pointYOrderedArray[index].X + pointYOrderedArray[index + 1].X) / 2;
                double y = (pointYOrderedArray[index].Y + pointYOrderedArray[index + 1].Y) / 2;
                Point[] refPoints = new Point[2];
                refPoints[0]=pointYOrderedArray[index];
                refPoints[1]=pointYOrderedArray[index + 1];
                anchorPoints.Add(new AnchorPoint(x, y, AnchorPointType.WE, refPoints));
            }
        }

        /// <summary>
        /// 绘制直线
        /// </summary>
        /// <param name="x1"></param>
        /// <param name="y1"></param>
        /// <param name="x2"></param>
        /// <param name="y2"></param>
        private void drawLine(double x1,double y1,double x2,double y2)
        {
            Line line = new Line()
            {
                X1 = x1,
                Y1 = y1,
                X2 = x2,
                Y2 = y2,
                StrokeThickness = 2,
                Stroke = Brushes.Red
            };
            lines.Add(line);
            canvas.Children.Add(line);
        }
    }
}
