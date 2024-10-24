<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="UserPage.aspx.cs" Inherits="React_Website_FrontEnd_Web.UserPage" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
      
      
    <div class="search-container">
        <input type="text" placeholder="Search..." />
        <%--button goes here--%>
    </div>
    <br />  
      
    
    <div class="Appetite_Books">   


        <%--//HERE LIES NEWEST ARRIVALS--%>

        <div class="arrivals">
            <br />

            <h2 style="text-align: center">Newest Arrivals</h2>

            <div class="arrivals_box" runat="server" id="newbooks">

                <br />
            </div>
             
                <script type="text/javascript">
                    function redirectToApsPage() {
                        // Redirect to aps.aspx
                        window.location.href = 'Cart.aspx';
                        return false; // Prevent postback
                    }
                </script>
               

        </div>

        <%--//HERE ENDS NEWEST ARRIVALS--%>  

        <div class="arrivals">
            <br />

            <h2 style="text-align: center">Best Selling Books</h2>

            <div class="arrivals_box" id="bestselling" runat="server">

              
                <br />
            </div>

        </div>



        <%--//This is for On sales book the STARTING--%>
        <div class="arrivals">
            <br />

            <h2 style="text-align: center">Sales</h2>
              
            <div class="arrivals_box" id="Salez" runat="server">
 
                <br />
            </div>

        </div>

        <%--//ADVENTURE TIME--%>
        <div class="arrivals">
            <br />

            <h2 style="text-align: center">ADVENTURE</h2>

            <div class="arrivals_box" id="Advent" runat="server" >

              
                 <br />
            </div>

        </div>

        <%--//ADVENTURES ENDS--%>



        <%--//BIOGRAPHY STARTS--%>
        <%--//BIOGRAPHY ENDS--%>

        <%-- CRIME STARTS --%>
        <div class="arrivals">
            <br />  
               
            <h2 style="text-align: center">BIOGRAPHY</h2>

            <div class="arrivals_box" runat="server" id="biographyBooks"> 

                
            </div>

        </div>


        <%--//CRIME ENDS--%>


        <%--//FANTASY STARTS--%>
        
        <%--//FANSTASY ENDS--%>

        <%--//FICTION STARTS--%>
 



        <%--//FICTION ENDS--%>

        <%--//HISTORY--%>
 



        <%--//HISTORY ENDS--%>

        <%--//HORROR STARTS--%>
 


        <%--//HORROR ENDS--%>

        <%--//MYSTERY STARTS--%>

   



        <%--//MYSTERY ENDS--%>

        <%--//NON-FICTION--%>


        <%--//NON-FICTION--%>

        <%--//POERTY STARTS--%>

       


        <%--//POETRY ENDS--%>

        <%--//ROMANCE STARTS--%>

           
                </div>

                
               

        <%--//ROMANCE ENDS--%>


        <%--//SELF-HELP STARTS--%>
 

        <%--//SELF-HELP ENDS--%>


        <%--//SCEINCE-FICTION STARTS--%>
 
        <%--///SCIENCE-FICTION ENDS--%>


        <%--//THRILLER STARTS--%>

 
        <%--//THRILLER ENDS--%>


        <%--//YOUNG ADULT STARTS--%>
        
        <%--//YOUNG ADULT ENDS--%>
    

        <script>   

            function showDetails(productId) {
                console.log("Now showing the details of product ID: " + productId);
            }

            function addToCart(productId) {
                console.log("Now adding to acrt product of ID: " + productId);
            }
        </script>

    
</asp:Content>
