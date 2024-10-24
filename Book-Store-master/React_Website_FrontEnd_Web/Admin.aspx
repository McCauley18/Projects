<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="React_Website_FrontEnd_Web.WebForm6" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
        <style type="text/css">
        .auto-style2 {
            width: 288px;
            height: 25px;
        }
        .auto-style6 {
            width: 288px;
        }
        .auto-style7 {
            width: 261px;
        }
        .auto-style8 {
            width: 261px;
            height: 25px;
        }
        .auto-style9 {
            width: 360px;
        }
        .auto-style10 {
            width: 360px;
            height: 25px;
        }
        
        .auto-style12 {
            margin-left: 225px;
        }

        #btnUpdate,btnDelete,Button1 {
    background-color: #000; /* Black background color */
    color: #fff; /* White text color */
    padding: 10px 20px; /* Padding around the text */
    border: none; /* Remove border */
    border-radius: 5px; /* Rounded corners */
    font-size: 16px; /* Font size */
    cursor: pointer; /* Cursor style */
    transition: background-color 0.3s ease; /* Smooth background color transition */
}

#btnUpdate:hover {
    background-color: #555; /* Darker gray on hover */
}
#btnDelete:hover {
    background-color: #555; /* Darker gray on hover */
}
#Button1:hover {
    background-color: #555; /* Darker gray on hover */
}
        </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

     <div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:Image ID="Image1" runat="server" Height="100px" ImageUrl="https://jbsl.co.nz/wp-content/uploads/2021/08/SmartBooks-Logo.png" />
    </div>
    <div style="color:black" class="auto-style12">
        
        <table class="w-100" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
            <tr>
                <th class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;" ><center>Delete Book</center></th>
                <th class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"><center>Add Book</center></th>
                <th class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"><center>Update Book</center></th>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;</td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;</td>

                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox8" runat="server"></asp:TextBox>
                &nbsp;&nbsp;&nbsp;
                    <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" Text="Search" />
                </td>                
            </tr>
            <tr>
                <th class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"></th>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Full Book Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                    Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox14" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"></td>
                <td class="auto-style8" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                    Description&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style10" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Description&nbsp;&nbsp;&nbsp; &nbsp;
                    <asp:TextBox ID="TextBox9" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;<asp:Label ID="Label1" runat="server"></asp:Label>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="btnDelete" runat="server" Text="Delete" OnClick="btnDelete_Click" />
                </td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                    Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox10" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;</td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                    Category&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Category&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox11" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">&nbsp;</td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                    Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">Quantity&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox12" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"></td>
                <td class="auto-style7"style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">ImageURL&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:TextBox ID="TextBox7" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">ImageURL&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                    <asp:TextBox ID="TextBox13" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style6" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;"></td>
                <td class="auto-style7" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="Button1" runat="server" Text="Add" OnClick="Button1_Click" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Label ID="Label2" runat="server"></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td class="auto-style9" style="border-color: #000080 #000080 #FFFFFF #000080; border-style: solid;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Button ID="btnUpdate" runat="server" Text="Update" OnClick="Button2_Click" Visible="False" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <asp:Label ID="Label3" runat="server"></asp:Label>
                </td>
            </tr>
            </table>
        
    </div>
</asp:Content>
