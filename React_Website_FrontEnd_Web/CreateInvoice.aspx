<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="CreateInvoice.aspx.cs" Inherits="React_Website_FrontEnd_Web.CreateInvoice" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
     <style type="text/css">
        
        .auto-style9 {
            margin-left: 225px;
        }
        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
      
    <div style="color:black; height: 811px;" class="auto-style9">

        <br />
        <asp:Image ID="Image1" runat="server" Height="100px" ImageUrl="https://jbsl.co.nz/wp-content/uploads/2021/08/SmartBooks-Logo.png" />
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <asp:Image ID="Image2" runat="server" Height="100px" ImageUrl="https://invoice-gen.com/assets/images/logo_f.png" />
        <br />
        <br />
        <br />
        <br />
        Book Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
        <asp:DropDownList ID="DropDownList1" runat="server">
            <asp:ListItem>Quotations from Chairman Mao Tse-TungL</asp:ListItem>
            <asp:ListItem>The Lord Of The Rings</asp:ListItem>
            <asp:ListItem>The Little Prince (Le Petit Prince)</asp:ListItem>
            <asp:ListItem>Harry Potter and the Philosopher’s Stone</asp:ListItem>
            <asp:ListItem>Scouting For Boys</asp:ListItem>
            <asp:ListItem>And Then There Were None</asp:ListItem>
            <asp:ListItem>The Hobbit</asp:ListItem>
            <asp:ListItem>The Dream Of The Red Chamber (Honglou Meng)</asp:ListItem>
            <asp:ListItem>To Kill a Mockingbird, by Harper Lee</asp:ListItem>
            <asp:ListItem>1984, by George Orwell</asp:ListItem>
            <asp:ListItem>The Great Gatsby</asp:ListItem>
            <asp:ListItem>Pride and Prejudice</asp:ListItem>
            <asp:ListItem>The Diary Of A Young Girl</asp:ListItem>
            <asp:ListItem>The Book Thief</asp:ListItem>
            <asp:ListItem>Little Women</asp:ListItem>
            <asp:ListItem>Fahrenheit 451</asp:ListItem>
            <asp:ListItem>Jane Eyre</asp:ListItem>
            <asp:ListItem>Animal Farm</asp:ListItem>
            <asp:ListItem>Gone with the Wind</asp:ListItem>
            <asp:ListItem>The Catcher in the Rye</asp:ListItem>
        </asp:DropDownList>
        <br />
        <p></p>
        Date to be delivered&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click">Click to Add Date</asp:LinkButton>
&nbsp;<asp:Calendar ID="cldDate" runat="server" Visible="False"></asp:Calendar>
        <br />
        <p></p>
        Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
        <br />
        <p></p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnDone" runat="server" Text="Done" OnClick="btnDone_Click" />
   
        <p></p>
        Total Price to pay:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Label ID="lblTotal" runat="server" Text="R0.00"></asp:Label>
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnProceed" runat="server" Text="Proceed" OnClick="btnProceed_Click" Visible="False" />

    </div>
    

</asp:Content>
