using Newtonsoft.Json;
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
            //List<Buton> buttonList = new List<Buton>();
            //XmlSerializer serial = new XmlSerializer(typeof(List<Buton>));
            //using (FileStream fs = new FileStream(Environment.CurrentDirectory + "\\butoane.xml", FileMode.Open, FileAccess.Read))
            //{
            //    buttonList = serial.Deserialize(fs) as List<Buton>;
            //}
            List<Buton> buttonList = new List<Buton>();
            string json = File.ReadAllText(Environment.CurrentDirectory + "\\butoane.json");
            buttonList = JsonConvert.DeserializeObject<List<Buton>>(json);
            foreach (Buton btn in buttonList)
            {
                Button b = new Button();            
                b.Text = btn.clicks.ToString();
                b.Width = 700;
                //if (Form1.getRandom())
                  //  b.BackColor = ColorTranslator.FromHtml("#" + btn.color);
                //else
                    b.BackColor = Color.FromName(btn.color);
                flowLayoutPanel1.Controls.Add(b);
                b.Click += B_Click;

            }
        }

        private void B_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int i = int.Parse(btn.Text);
            i++;
            btn.Text = i.ToString();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
