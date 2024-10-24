using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using React_Website_FrontEnd_Web.ServiceReference1;

namespace React_Website_FrontEnd_Web
{
    public partial class Checkout : System.Web.UI.Page
    {
        ServiceClient sc = new ServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Invoice invoice = new Invoice
            {
                InvoiceDate = System.DateTime.Today,
                ProductID = Convert.ToInt32(Session["CartProdID"]),
                quantitySold = Convert.ToInt32(Session["CartQuantity"]),
                UserID = Convert.ToInt32(Session["UserID"]),
                TotalAmount = Convert.ToInt32(Session["CartTotal"]),
                DateDelivered = Calendar1.SelectedDate
            };

            PaymentMethod paymentMethod = new PaymentMethod
            {
                Address = txtAddress.Text,
                CardNumber = txtCardNo.Text,
                NameOnCard = txtCardName.Text,
                PostalCode = Convert.ToInt32(txtCode.Text),
                Town = txtTown.Text,
                UserID = Convert.ToInt32(Session["UserID"])
            };

            int successMethod = sc.AddPaymentMethod(paymentMethod);
            int success = sc.AddInvoice(invoice);
            Response.Redirect("Invoices.aspx");
        }
    }
}