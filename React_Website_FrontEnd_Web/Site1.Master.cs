using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace React_Website_FrontEnd_Web
{
    public partial class Site1 : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string sSess = "";
            try
            {
                sSess = Convert.ToString(Session["UserID"]);
                if (sSess.Equals(""))
                {
                    invoice.Visible = false;
                 //   products.Visible = false;                    
                }
                else
                {
                    invoice.Visible = true;
                }
            }
            catch (Exception ex)
            {  
                ex.GetBaseException();
                invoice.Visible = false;
            }



        }
    }
}