using Microsoft.VisualBasic;
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
        }

        public void generateButton(int tag,Color colors)
        {
            Button btn = new Button();
            btn.Text = "0";
            btn.Tag = tag;
            btn.Width = 650;
            flowLayoutPanel1.Controls.Add(btn);
            btn.BackColor = colors;
            B1.Add(new Buton() { clicks = 0, color = colors.Name });
            btn.Click += Btn_Click;
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

        private void btnChoose_Click(object sender, EventArgs e)
        {
            string color = string.Empty;
            color = Interaction.InputBox("Write 10 colors ( separated by , ) for each button.\nNOTE: if you enter less than 10 colors" +
                ", the ones that you don't fill in will have the default color!" +
                "\nIf left blank buttons will be default color.","Choose Colors"," ");
            String[] culori = color.Split(',');
            Color []c = new Color[10];
            for(int i = 0; i < culori.Length; i++)        
                culori[i] = char.ToUpper(culori[i].ElementAt(0)) + culori[i].Substring(1);
            if (culori.Length > 10)
            {
                MessageBox.Show("Prea multe culori", "Eroare", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            if (culori.Length == 0)
            {
                for (int i = 0; i < 10; i++)
                    c[i] = SystemColors.Control;
            }
            else
            {
                for (int i = 0; i < culori.Length; i++)
                    c[i] = Color.FromName(culori[i]);
                if (culori.Length != 10)
                    for (int i = culori.Length; i < 10; i++)
                        c[i] = SystemColors.Control;
            }
            for(int i = 0;i<10;i++)
                generateButton(i,c[i]);
            Controls.Remove(btnChoose);
            Controls.Remove(btnRandom);


        }
        private void btnRandom_Click(object sender, EventArgs e)
        {
            Random rnd = new Random();
            KnownColor[] names =(KnownColor[]) Enum.GetValues(typeof(KnownColor));
            for (int i = 0; i < 10; i++)
            {
                KnownColor randomColorName = names[rnd.Next(names.Length)];
                Color randomColor = Color.FromKnownColor(randomColorName);
                generateButton(i, randomColor);
            }
            Controls.Remove(btnChoose);
            Controls.Remove(btnRandom);
        }
    }
}
