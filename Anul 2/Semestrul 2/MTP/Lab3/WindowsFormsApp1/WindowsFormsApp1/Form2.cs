using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Serialization;

namespace WindowsFormsApp1
{
    public partial class Form2 : Form
    {
        
        public Form2()
        {
            InitializeComponent();
            List<Buton> buttonList = new List<Buton>();
            XmlSerializer serial = new XmlSerializer(typeof(List<Buton>));
            using (FileStream fs = new FileStream(Environment.CurrentDirectory + "\\butoane.xml", FileMode.Open, FileAccess.Read))
            {
                buttonList = serial.Deserialize(fs) as List<Buton>;
            }
            foreach (Buton btn in buttonList)
            {
                Button b = new Button();            
                b.Text = btn.clicks.ToString();
                b.Width = 700;
                b.BackColor = ColorTranslator.FromHtml("#" + btn.color);
                flowLayoutPanel1.Controls.Add(b);


            }
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
