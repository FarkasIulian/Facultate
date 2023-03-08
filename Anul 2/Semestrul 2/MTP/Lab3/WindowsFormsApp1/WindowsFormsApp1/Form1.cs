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
    public partial class Form1 : Form
    {
        List<Buton> B1 = new List<Buton>();
        public Form1()
        {
            InitializeComponent();
            Random rnd = new Random();
            for (int i = 0; i < 10; i++)
            {
                Color randomColor = Color.FromArgb(rnd.Next(256), rnd.Next(256), rnd.Next(256));
                Button btn = new Button();
                btn.Text = "0";
                btn.Tag = i;
                btn.Width = 700;
                flowLayoutPanel1.Controls.Add(btn);
                btn.BackColor = randomColor;
                B1.Add(new Buton() { clicks = 0, color = randomColor.Name.ToString()});
                btn.Click += Btn_Click;
            }
        }

        private void Btn_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int i = int.Parse(btn.Text);
            i++;
            int index = int.Parse(btn.Tag.ToString());
            B1[index].clicks = i;
            btn.Text = i.ToString();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            XmlSerializer serial = new XmlSerializer(typeof(List<Buton>));
            using (FileStream fs = new FileStream(Environment.CurrentDirectory + "\\butoane.xml", FileMode.Create,
           FileAccess.Write))
            {
                serial.Serialize(fs, B1);
                MessageBox.Show("Baza de date creata!");
            } 
        }

        private void btnXML_Click(object sender, EventArgs e)
        {
            Form f = new Form2();
            f.ShowDialog();
        }
    }
}
