using React_Website_FrontEnd_Web.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace React_Website_FrontEnd_Web
{
    public partial class SignInPage : System.Web.UI.Page
    {  
        ServiceClient sc = new ServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            string Useremail = email.Value;
            string pass = password.Value;
            Session["UserID"] = "";
              
            var user = sc.GetUserName(Useremail);
            bool loggedIn = sc.UserLogin(Useremail, pass);
            if (user != null && loggedIn)
            {
                if (user.UserType.Equals(0))
                {  
                    //Session["ManagerLogIn"] = "Yes";
                    // Response.Redirect("ProdutsPage.aspx");
                    if (chbAddAdmin.Checked)
                    {
                        Session["AddManager"] = "Yes";
                        Response.Redirect("SignUpPage.aspx");
                    }
                    else
                    {
                        Session["AddManager"] = "Yes";
                        Response.Redirect("Admin.aspx");
                    }
                }
                else
                {
                    Session["ManagerLogIn"] = "No";
                    Session["UserID"] = user.Id;
                    Session["AddManager"] = "No";
                    Response.Redirect("UserPage.aspx");
                }
            }
            else
            {
                lblWrong.Visible = true;
                lblWrong.Text = "Incorrect username or password";
            }

        }
    }
}