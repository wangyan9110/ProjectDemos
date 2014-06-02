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
using System.IO;

namespace WPFCanvas
{
    /// <summary>
    /// Cursor.xaml 的交互逻辑
    /// </summary>
    public partial class CursorTest : Window
    {
     //  Cursor CustomCursor;
       public CursorTest()
        {
        //    CustomCursor = new Cursor(Directory.GetCurrentDirectory() + System.IO.Path.DirectorySeparatorChar + "CustomCursor.cur");
        }
        public void CursorTypeChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBox source = e.Source as ComboBox;
            if (source != null)
            {
                ComboBoxItem selectedCursor = source.SelectedItem as ComboBoxItem;
                switch (selectedCursor.Content.ToString())
                {
                    case "AppStarting":
                        DisplayArea.Cursor = Cursors.AppStarting;
                        break;
                    case "ArrowCD":
                        DisplayArea.Cursor = Cursors.ArrowCD;
                        break;
                    case "Arrow":
                        DisplayArea.Cursor = Cursors.Arrow;
                        break;
                    case "Cross":
                        DisplayArea.Cursor = Cursors.Cross;
                        break;
                    case "HandCursor":
                        DisplayArea.Cursor = Cursors.Hand;
                        break;
                    case "Help":
                        DisplayArea.Cursor = Cursors.Help;
                        break;
                    case "IBeam":
                        DisplayArea.Cursor = Cursors.IBeam;
                        break;
                    case "No":
                        DisplayArea.Cursor = Cursors.No;
                        break;
                    case "None":
                        DisplayArea.Cursor = Cursors.None;
                        break;
                    case "Pen":
                        DisplayArea.Cursor = Cursors.Pen;
                        break;
                    case "ScrollSE":
                        DisplayArea.Cursor = Cursors.ScrollSE;
                        break;
                    case "ScrollWE":
                        DisplayArea.Cursor = Cursors.ScrollWE;
                        break;
                    case "SizeAll":
                        DisplayArea.Cursor = Cursors.SizeAll;
                        break;
                    case "SizeNESW":
                        DisplayArea.Cursor = Cursors.SizeNESW;
                        break;
                    case "SizeNS":
                        DisplayArea.Cursor = Cursors.SizeNS;
                        break;
                    case "SizeNWSE":
                        DisplayArea.Cursor = Cursors.SizeNWSE;
                        break;
                    case "SizeWE":
                        DisplayArea.Cursor = Cursors.SizeWE;
                        break;
                    case "UpArrow":
                        DisplayArea.Cursor = Cursors.UpArrow;
                        break;
                    case "WaitCursor":
                        DisplayArea.Cursor = Cursors.Wait;
                        break;
                    case "Custom":
                    //    DisplayArea.Cursor = CustomCursor;
                        break;
                    default:
                        break;
                }
            }
        }
        public void OnLoaded(object sender, RoutedEventArgs e)
        {
            ((ComboBoxItem)CursorSelector.Items[0]).IsSelected = true;
        }
    }
}
