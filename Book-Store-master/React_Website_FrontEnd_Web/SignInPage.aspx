<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="SignInPage.aspx.cs" Inherits="React_Website_FrontEnd_Web.SignInPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <div class="footer-container">
      <section class="footer-subscription">
         <p class="footer-subscription footer-subscription-heading">
          Welcome Back
        </p>
        <div class="input-areas">
          <formview>
            <input
                class="footer-input"
                name="email"
                id="email"
                runat="server"
                type="email"
                placeholder="Enter your email address"
                style="width:700px;"
            />
              <br />
            
            
             <input
              class="footer-input"
              name="password"
              type="password"
                 id="password"
                 runat="server"
              placeholder="Password"
              style="width:700px;"
                 required
           
            />

              <br />
              <asp:CheckBox ID="chbAddAdmin" Text="Add an Admin" runat="server" />
              <br />
               <asp:Label ID="lblWrong" runat="server" Text="Label" Visible="false"></asp:Label>

                <br />
            <asp:Button 
                 ID="btnLogin"
                 runat="server"
                 Text="Login"
                 class=" btn btn--outline btn-medium btn-block" 
                 type="submit"
                 OnClientClick="return redirectToApsPage();" 
                 style="width:700px;"
                 ></asp:Button>
               


                <script type="text/javascript">
                    function redirectToApsPage(id) {
                        // Redirect to aps.aspx
                        var intID = int;
                        window.location.href = 'UserPage.aspx';
                        return false; // Prevent postback
                    }
                </script>
          </formview>
        </div>
      </section>
    </div>

    
 

</asp:Content>
