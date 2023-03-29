using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApp1
{
    public partial class Gestionare_clase : Form
    {
        public Gestionare_clase()
        {
            InitializeComponent();
            IncarcareEchipe();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            IncarcareJucator(comboBox1.Text);
   
        }

        private void IncarcareEchipe()
        {
            flowLayoutPanel1.Controls.Clear();
            comboBox1.Items.Clear();
            foreach (string dirPath in Directory.EnumerateDirectories(Application.StartupPath))
            {
                DirectoryInfo dirName = new DirectoryInfo(dirPath);
                comboBox1.Items.Add(dirName.Name);
            }
        }
        private void IncarcareJucator(string clasa)
        {
            flowLayoutPanel1.Controls.Clear();
            string path = Application.StartupPath + "\\" + clasa;
            foreach(string fileName in Directory.EnumerateFiles(path, "*.cls"))
            {
                using(StreamReader reader = new StreamReader(fileName))
                {
                 
                    string cnp = Path.GetFileNameWithoutExtension(fileName);
                    string nume = reader.ReadLine();
                    string post = reader.ReadLine();
                    Class1 J = new Class1(nume, cnp, post);
                   
                    Button btn = new Button();
                    btn.Text = J.Nume;
                    btn.Width = 200;
                    btn.Tag = J;
                    flowLayoutPanel1.Controls.Add(btn);
                    btn.Click += Btn_Click;
                }
            }
        }

        private void Btn_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            Button btn = (Button)sender;
            Class1 J = (Class1)btn.Tag;
            listBox1.Items.Add("Numele: " + J.Nume);
            listBox1.Items.Add("CNP: " + J.Cnp);
            listBox1.Items.Add("Post: " + J.Post);
        }

        private void btnEchipa_Click(object sender, EventArgs e)
        {
            flowLayoutPanel2.Controls.Clear();
            TextBox textBoxEchipa = new TextBox();
            textBoxEchipa.Width = 150;
            Button btnAdd = new Button();
            btnAdd.Text = "OK";
            flowLayoutPanel2.Controls.Add(textBoxEchipa);
            flowLayoutPanel2.Controls.Add(btnAdd);

        }
    }
    
}
