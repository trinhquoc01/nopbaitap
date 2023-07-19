// See https://aka.ms/new-console-template for more information

using exam.Controller;
using System;

ProductController productController = new ProductController();

int choose = 0;

try
{
    do
    {
        Console.WriteLine("---- Product Management Menu ----");
        Console.WriteLine("1.Add Product");
        Console.WriteLine("2.Display all products");
        Console.WriteLine("3.Delete product by Id");
        Console.WriteLine("4.Exit");

        choose = int.Parse(Console.ReadLine());

        switch (choose)
        {
            case 1:

                productController.AddProduct();
                break;
            case 2:
                productController.DisplayAllProduct();
                break;
            case 3:
                productController.DeleteProductById();
                break;
            case 4:
                return;
        }
    } while (true);
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
} 


