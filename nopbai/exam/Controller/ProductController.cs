using exam.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace exam.Controller
{
    internal class ProductController
    {
        private List<Product> products = new List<Product>();

        public void AddProduct() 
        {
            Console.WriteLine("---- Add Prodcut ----");
            Console.Write("Enter Product Id : ");
            string productId = Console.ReadLine();

            Console.Write("Enter Product Name : ");
            string name = Console.ReadLine();

            Console.Write("Enter Product Price :$");
            double price = int.Parse(Console.ReadLine());

            Product product = new Product
            {
                ProductId = productId,
                Name = name,
                Price = price
            };

            products.Add(product);
            Console.WriteLine(" Add successfully ");

        }

        public void DisplayAllProduct() 
        {
            Console.WriteLine("---- All Products ----");
            if(products.Count == 0)
            {
                Console.WriteLine(" No Products ");
            }
            else
            {
                foreach (var product in products) 
                {
                    Console.WriteLine($"ProductId               " + "Product Name               " + "Price");
                    Console.WriteLine($"{product.ProductId}                      " + $"{product.Name}                  " + $"${product.Price}");
                }
                Console.WriteLine();
            }
        }

        public void DeleteProductById()
        {
            Console.WriteLine("---- Delete Product By Id ----"); 
            Console.Write("Enter ProductId : ");
            string productId = Console.ReadLine();

            Product productRemove = products.Find(p => p.ProductId == productId);

            if (productRemove != null)
            {
                products.Remove(productRemove);
                Console.WriteLine("Delete successfully");
            }
            else 
            {
                Console.WriteLine("Product not found");
            }
        }
    }
}
