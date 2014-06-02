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
using System.Windows.Shapes;

namespace WPFCanvas
{
    /// <summary>
    /// VarRectTest.xaml 的交互逻辑
    /// </summary>
    public partial class VarRectTest : Window
    {
        public VarRectTest()
        {
            InitializeComponent();
            VarRectangle varRect = new VarRectangle(answerCard, GetPoints());
            varRect.Init();
        }

        private List<Point> GetPoints()
        {
            List<Point> points = new List<Point>();
            points.Add(new Point(100, 100));
            points.Add(new Point(100, 400));
            points.Add(new Point(500, 100));
            points.Add(new Point(500, 400));
        //  points.Add(new Point(100,200));
         //   points.Add(new Point(500,200));
            return points;
        }
    }
}
