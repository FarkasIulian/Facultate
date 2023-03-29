using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApp1
{
    internal class Class1
    {
        private string nume, cnp, post;

        public Class1(string nume, string cnp, string post)
        {
            this.nume = nume;
            this.cnp = cnp;
            this.post = post;
        }
        public string Nume { get => nume; set => nume = value; }
        public string Cnp { get => cnp; set => cnp = value; }
        public string Post { get => post; set => post = value; }
    }
}
