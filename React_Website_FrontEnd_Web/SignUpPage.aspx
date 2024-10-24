<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="SignUpPage.aspx.cs" Inherits="React_Website_FrontEnd_Web.SignUpPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
  
    <title>Sign Up </title>
     <link href="CSS/SignUpInput.css" rel="stylesheet" />
      
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    
    <div >     
    <div class="footer-container" runat="server">
      <section class="footer-subscription" runat="server">
        <p class="footer-subscription footer-subscription-heading">
          Create a new account to purchase books
        </p>
        <div class="input-areas" runat="server">  
          <formview runat="server">  
            <input 
                class="footer-input"
                name="email"  
                type="email"
                placeholder="Enter your email address"
                style="width:700px;"
                id="emailaddress"
                runat="server"
            />
              <br />
             <input
                    class="footer-input"
                    name="Firstname"
                    type="text"
                    runat="server"
                 id="firstname"
                    placeholder="First name"
                     style="width:700px;"
                    required
                />
                <br />
              <input
                    class="footer-input"
                    name="Lastname"
                   runat="server"
                  id="lastname"
                    type="text"
                    placeholder="Last name"
                   style="width:700px;"
                  required
                />
                <br />
              <input
                    class="footer-input"
                    name="phoneNumber"
                    type="text"
                   runat="server"
                  id="phonenumber"
                    placeholder="Phone number"
                   style="width:700px;"
                  required
                />
                
                <br />
            <!--  <input
                    class="footer-input"
                    name="userType"
                    type="text"
                   runat="server"  
                  id="usertype"
                    placeholder="0 for admin and 1 for customer"
                   style="width:700px;"
                  required
                />
                <br /> -->
             <input
              class="footer-input"
              name="password"
              type="password"  
                  runat="server"
                 id="password"
              placeholder="Password"
              style="width:700px;"
                 required
            />

              <br />
             <input  
              class="footer-input"  
              name="confirmpassword"
              type="password"   
                  runat="server"
                 id="confirmpassword"
              placeholder="Confirm Password"
              style="width:700px;"
                 required
            />
              <br />
              <asp:Label ID="lblExists" runat="server" Text="User Already registered" Visible="false"></asp:Label>
                <br />

            <asp:Button 
                 ID="signUpBtn"  
                 runat="server"  
                 Text="Create Account"
                 class=" btn btn--outline btn-medium btn-block" 
                 OnClick="signUpBtn_Click"  
                 style="width:700px;"
            ></asp:Button>               
                <script type="text/javascript">
                    function redirectToApsPage() {
                        // Redirect to aps.aspx
                        window.location.href = 'UserPage.aspx';
                        return false; // Prevent postback
                    }
                </script>
          </formview>
        </div>
      </section>
    </div>

        </div>




</asp:Content>
