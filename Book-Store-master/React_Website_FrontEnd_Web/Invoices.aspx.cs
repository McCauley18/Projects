using React_Website_FrontEnd_Web.ServiceReference1;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace React_Website_FrontEnd_Web
{
    public partial class WebForm5 : System.Web.UI.Page
    {
        ServiceClient sc = new ServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            string tableInvoice = "";

            tableInvoice += "<table class='auto-style9' style='border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;'>";
            tableInvoice += "<tr>";
            tableInvoice += "<td class='auto-style4'><b>Books</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>";
            tableInvoice += "<td><b>Quantity</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>";
            tableInvoice += "<td><b>Date Purchased</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>";
            tableInvoice += "<td class='auto-style10'><b>Total Price</b></td>";
            tableInvoice += "</tr>";

            int userId = Convert.ToInt32(Session["UserID"]);
            dynamic ID = sc.GetInvoice(userId); //To be changed use session
            User user = sc.GetUser(userId);

            if (ID != null)
            {
                foreach (Invoice i in ID)
                {
                    string prodName = sc.GetProductName(i.ProductID); //To be changed use session

                    tableInvoice += "<tr>";
                    tableInvoice += "<td>" + prodName + "</td>";
                    tableInvoice += "<td>" + i.quantitySold + "</td>";
                    tableInvoice += "<td>" + Convert.ToString(i.InvoiceDate).Substring(0, 10) + "</td>";
                    tableInvoice += "<td>R" + Math.Round(i.TotalAmount, 2) + "</td>";
                    tableInvoice += "</tr>";
                }
            }
            tableInvoice += "</table>";

            invoice_table_info.InnerHtml = tableInvoice;

            Label1.Text = Convert.ToString(user.Id);
            Label2.Text = Convert.ToString(System.DateTime.Today).Substring(0, 10);
            Label3.Text = user.FirstName + " " + user.LastName;
            Label5.Text = user.Email;
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Response.Redirect("CreateInvoice.aspx?ID=" + Convert.ToString(Session["UserID"]));
        }
    }
}