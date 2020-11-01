using FireSharp.Response;
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
    public partial class Main : Form
    {
        DataTable dt = new DataTable();
        DataTable sdt = new DataTable();
        IFirebaseConfig config = new FirebaseConfig
        {
            AuthSecret = "I6AoonBAMSIklLgkKA1rPMBb3xxIELiDCvr7YtlX",
            BasePath = "https://salary-package.firebaseio.com/"
        };
        IFirebaseClient client;
        public Main()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private async void btnsave_Click(object sender, EventArgs e)
        {
            FirebaseResponse resp = await client.GetTaskAsync("Counter/node");
            Counter_Class get = resp.ResultAs<Counter_Class>();
            //MessageBox.Show(get.cnt);

             var data = new Data
             {
                 ID = (Convert.ToInt32(get.cnt)+1).ToString(),
                 Fname = emplyfname.Text,
                 Lname = emplylname.Text

             };

            SetResponse response = await client.SetTaskAsync("Information/" + data.ID, data);
            Data result = response.ResultAs<Data>();
            //var set = client.Set(@"Information/" + emplyID.Text, data);
            // MessageBox.Show("Inserted Sucessfully");

            var obj = new Counter_Class
            {
                cnt = data.ID
            };
            SetResponse response1 = await client.SetTaskAsync("Counter/node", obj);

            MessageBox.Show("Employee ID is" + data.ID);
            emplyID.Text = data.ID;

            export();
           /* emplyID.Text = " ";
            emplyfname.Text = " ";
            emplylname.Text = " ";*/

        }

        private void Main_Load(object sender, EventArgs e)
        {
            try
            {
                client = new FireSharp.FirebaseClient(config);
            }
            catch
            {
                MessageBox.Show("Internet Error");
            }

            dt.Columns.Add("Employee ID");
            dt.Columns.Add("First Name");
            dt.Columns.Add("Last Name");

            table.DataSource = dt;
            export();

            sdt.Columns.Add("Employee ID");
            sdt.Columns.Add("First Name");
            sdt.Columns.Add("Last Name");

            searchtable.DataSource = sdt;
        }

        private void btnretrive_Click(object sender, EventArgs e)
        {
            var res = client.Get(@"Information/" + emplyID.Text);
            Data data = res.ResultAs<Data>();

            emplyfname.Text = data.Fname;
            emplylname.Text = data.Lname;

          //  MessageBox.Show("Retrived Sucessfully");

        }

        private void btnreset_Click(object sender, EventArgs e)
        {
            var data = new Data
            {
                ID = emplyID.Text,
                Fname = emplyfname.Text,
                Lname = emplylname.Text

            };
            var set = client.Update(@"Information/" + emplyID.Text, data);
            //MessageBox.Show("Updated Sucessfully");
            export();
        }

        private void btndelete_Click(object sender, EventArgs e)
        {
            var set = client.Delete(@"Information/" + emplyID.Text);
            // MessageBox.Show("Deleted Sucessfully");
            export();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
            DataView dv = new DataView(dt);
            dv.RowFilter = "[" + comboBox1.Text + "]" + "LIKE '%" + txtsearch.Text + "%'";
            searchtable.DataSource = null;
            searchtable.Rows.Clear();
            searchtable.Columns.Clear();
            searchtable.DataSource = dv;

            //txtsearch.Text = " ";
            //comboBox1.Text = " ";

            

        }

        private async void export()
        {
            dt.Rows.Clear();
            int i = 0;
            FirebaseResponse resp1 = await client.GetTaskAsync("Counter/node");
            Counter_Class obj1 = resp1.ResultAs<Counter_Class>();
            int cnt = Convert.ToInt32(obj1.cnt);
            
            while(true)
            {
                if(i==cnt)
                {
                    break;
                }
                i++;
                try
                {
                    FirebaseResponse resp2 = await client.GetTaskAsync("Information/"+i);
                    Data obj2 = resp2.ResultAs<Data>();

                    DataRow row = dt.NewRow();
                    row["Employee ID"] = obj2.ID;
                    row["First Name"] = obj2.Fname;
                    row["Last Name"] = obj2.Lname;

                    dt.Rows.Add(row);
                }
                catch
                {

                }
            }
        }

        private void btnfulldisplay_Click(object sender, EventArgs e)
        {
            export();
        }
    }
}

