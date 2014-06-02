using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Input;
using System.Windows.Shapes;
using System.Windows;
using System.Windows.Media;

namespace WPFCanvas
{
    /// <summary>
    /// 定位点
    /// </summary>
    public class AnchorPoint
    {
        /// <summary>
        /// 唯一标记
        /// </summary>
        public string Key { get; set; }

        /// <summary>
        /// X坐标
        /// 中心点坐标或者说控制点坐标，所有线的端点坐标为该坐标的需要联动
        /// </summary>
        public double X { get; set; }

        /// <summary>
        /// Y坐标
        /// 中心点坐标或者说控制点坐标，所有线的端点坐标为该坐标的需要联动
        /// </summary>
        public double Y { get; set; }

        /// <summary>
        /// 宽度
        /// </summary>
        public double Width { get; set; }

        /// <summary>
        /// 高度
        /// </summary>
        public double Height { get; set; }

        /// <summary>
        /// 鼠标形状
        /// </summary>
        public Cursor Cursor { get; set; }

        /// <summary>
        /// 位置
        /// </summary>
        public AnchorPointType AnchorPointType { get; set; }

        /// <summary>
        /// 关联点，可能为null
        /// 比如直线中点定位点，则关联点则为两头的点
        /// </summary>
        public Point[] RefPoint { get; set; } 

        private Rectangle retc;

        /// <summary>
        /// 默认构造器
        /// </summary>
        public AnchorPoint()
        { }

        /// <summary>
        /// 带参数的构造器
        /// </summary>
        /// <param name="X">X</param>
        /// <param name="y">Y</param>
        /// <param name="cursor">鼠标</param>
        public AnchorPoint(double x, double y, AnchorPointType anchorPointType)
            :this(x,y,anchorPointType,new Point[0])
        {

        }

        /// <summary>
        /// 参数构造器
        /// </summary>
        /// <param name="x"></param>
        /// <param name="y"></param>
        /// <param name="cursor"></param>
        /// <param name="refPoint"></param>
        public AnchorPoint(double x,double y,AnchorPointType anchorPointType,Point[] refPoints) 
        {
            this.X = x;
            this.Y = y;
            this.AnchorPointType = anchorPointType;
            this.Width = 8;
            this.Height = 8;
            this.Key = Guid.NewGuid().ToString();
            this.RefPoint = refPoints;
            switch (this.AnchorPointType)
            {
                case AnchorPointType.NS:
                    this.Cursor = Cursors.SizeNS; break;
                case WPFCanvas.AnchorPointType.WE:
                    this.Cursor = Cursors.SizeWE; break;
                case WPFCanvas.AnchorPointType.NE:
                case WPFCanvas.AnchorPointType.SW:
                    this.Cursor = Cursors.SizeNESW; break;
                case WPFCanvas.AnchorPointType.NW:
                case WPFCanvas.AnchorPointType.SE:
                    this.Cursor = Cursors.SizeNWSE; break;
            }
        }

        /// <summary>
        /// 绘制对象
        /// </summary>
        /// <returns>绘制的矩形</returns>
        public Rectangle Draw() 
        {
            double offset = this.Width / 2;
            Rectangle retc = new Rectangle()
            {
                Margin = new Thickness(this.X - offset, this.Y - offset, 0, 0),
                Width = this.Width,
                Height = this.Height,
                Fill = Brushes.LightGoldenrodYellow,
                Stroke = Brushes.Black,
                StrokeThickness = 1,
                DataContext = this.Key
            };
            this.retc = retc;
            return retc;
        }

        public void Move(double x,double y)
        {
            double offset = this.Width / 2;
            this.retc.Margin = new Thickness(x-offset,y-offset,0,0);
            this.X = x;
            this.Y = y;
        }

        public void Move()
        {
            double offset = this.Width / 2;
            this.retc.Margin = new Thickness(X - offset, Y - offset, 0, 0);
        }
    }
}
