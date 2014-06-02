using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Ink;

namespace WPFCanvas
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            //Rectangle ply = new Rectangle();
            //answerCard.Children.Add(ply);
            //ply.Fill = Brushes.Blue;
            //ply.Stroke = Brushes.Black;
            //ply.StrokeThickness = 1;
            List<Point> points = getPoints();
            List<Point> recPoints = new List<Point>();
            recPoints.AddRange(points);
            IEnumerable<IGrouping<double, Point>> pointXs = points.GroupBy(o => o.X);
            IEnumerable<IGrouping<double, Point>> pointYs=points.GroupBy(o=>o.Y);
            foreach (IGrouping<double, Point> pointX in pointXs)
            {
                double y1= pointX.Max(o => o.Y);
                double y2 = pointX.Min(o=>o.Y);
                Line line = new Line() 
                {
                    X1=pointX.Key,
                    Y1=y1,
                    X2=pointX.Key,
                    Y2=y2,
                    StrokeThickness=2,
                    Stroke=Brushes.Red
                };
                recPoints.Add(new Point(pointX.Key,(y1+y2)/2));
                answerCard.Children.Add(line);
            }
            foreach (IGrouping<double, Point> pointY in pointYs)
            {
                double x1 = pointY.Max(o => o.X);
                double x2 = pointY.Min(o => o.X);
                Line line = new Line()
                {
                    X1 = x1,
                    Y1 = pointY.Key,
                    X2 = x2,
                    Y2 = pointY.Key,
                    StrokeThickness = 2,
                    Stroke = Brushes.Red
                };
                recPoints.Add(new Point((x1 + x2) / 2, pointY.Key));
                answerCard.Children.Add(line);
            }

            foreach (Point point in recPoints)
            {

                Rectangle retc = new Rectangle()
                {
                    Margin = new Thickness(point.X - 4, point.Y - 4, 0, 0),
                    Width = 8,
                    Height = 8,
                    Fill = Brushes.LightGoldenrodYellow,
                    Stroke = Brushes.Black,
                    StrokeThickness = 1,
                };
                retc.DataContext = "test";
                retc.MouseDown += new MouseButtonEventHandler(path_MouseDown);
                retc.MouseLeftButtonDown += new MouseButtonEventHandler(retc_MouseLeftButtonDown);
                retc.MouseEnter += new MouseEventHandler(retc_MouseEnter);
                retc.MouseMove += new MouseEventHandler(retc_MouseMove);
                retc.MouseLeave += new MouseEventHandler(retc_MouseLeave);
                answerCard.Children.Add(retc);  
            }
        }

        void retc_MouseLeave(object sender, MouseEventArgs e)
        {
            this.Cursor = Cursors.Arrow;
        }

        void retc_MouseMove(object sender, MouseEventArgs e)
        {
          //  textLable.Content = e.GetPosition(answerCard).X.ToString() + "," + e.GetPosition(answerCard).Y.ToString();
            textLable.Content = ((Rectangle)sender).DataContext;
            Mouse.SetCursor(Cursors.SizeNS);
        }

        void retc_MouseEnter(object sender, MouseEventArgs e)
        {
            Mouse.SetCursor(Cursors.SizeNS);
        }

        void retc_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            Mouse.SetCursor(Cursors.SizeNS);
            this.Cursor = Cursors.SizeNS;
        }

        void path_MouseDown(object sender, MouseButtonEventArgs e)
        {
            Mouse.SetCursor(Cursors.SizeNS);
        }

        void path_MouseEnter(object sender, MouseEventArgs e)
        {
            //Mouse.SetCursor(Cursors.ScrollN);
            textLable.Content = "jinru";
        }

        private List<Point> getPoints()
        {
            List<Point> points = new List<Point>();
            points.Add(new Point(200,200));
            points.Add(new Point(200,500));
            points.Add(new Point(600, 200));
            points.Add(new Point(600, 500));
            return points;
        }
    }
}
