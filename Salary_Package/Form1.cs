using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using FireSharp.Config;
using FireSharp.Interfaces;
using FireSharp.Response;

namespace Salary_Package
{

    public partial class Form1 : Form
    {
        IFirebaseConfig config = new FirebaseConfig
        {
            AuthSecret= "I6AoonBAMSIklLgkKA1rPMBb3xxIELiDCvr7YtlX",
            BasePath= "https://salary-package.firebaseio.com/"
        };

        IFirebaseClient client;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnlogin_Click(object sender, EventArgs e)
        {
            String id = txtID.Text;
            String pass = txtpassword.Text;

            if(id == "admin" && pass == "admin")
            {
                this.Hide();
                Main m = new Main();
                m.Show();
            }
        }

        private void txtpassword_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            client = new FireSharp.FirebaseClient(config);

            if(client!=null)
            {
                //MessageBox.Show("Connection is established");
            }
        }
    }
}

