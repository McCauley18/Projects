<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Cart.aspx.cs" Inherits="React_Website_FrontEnd_Web.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
 <style type="text/css">
        .custom-gridview {
            width: 50%; /* Set the width of the GridView */
        }

        .custom-gridview th,
        .custom-gridview td {
            padding: 15px; /* Set padding for header and data cells */
            text-align: center; /* Center-align text within cells */
        }
    </style>
<div>
    <asp:Label ID="CartEmptyLabel" runat="server" Text="No Items in the Cart" Visible="false" />
    <asp:GridView ID="GridViewCart" runat="server" AutoGenerateColumns="False" ShowFooter="True" CssClass="custom-gridview">
        <Columns>
            <asp:BoundField DataField="ProductName" HeaderText="Name" />
            <asp:TemplateField HeaderText="Quantity">
                <ItemTemplate>
                    <asp:TextBox ID="TextBoxQuantity" runat="server" Text='<%# Eval("Quantity") %>'></asp:TextBox>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Item Total">
                <ItemTemplate>
                    <asp:Label ID="LabelItemTotal" runat="server" Text='<%# Convert.ToDecimal(Eval("PricePerUnit")) * Convert.ToInt32(Eval("Quantity")) %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Remove Item">
                <ItemTemplate>
                    <asp:CheckBox ID="Remove" runat="server"></asp:CheckBox>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>

    </asp:GridView>
</div>
<div>

    <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <asp:Button ID="Button1" runat="server" Text="Proceed to CheckOut" OnClick="Button1_Click" />

</div>

</asp:Content>
