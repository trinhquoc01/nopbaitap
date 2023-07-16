using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAppADONET
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StudentController studentController = new StudentController();
            //studentController.GetAllStudents();

            //Student student = new Student { Name = "Tom", Email = "tom@gmail.com", Level = 2 };
            //studentController.CreateNewStudent(student);

            //Get Student from DB by ID = 2

            Student student 
                = new Student { Id = 2, Name = "Tom Cruise", Email = "tomCruise@gmail.com", Level = 2 };
            studentController.UpdateStudent(student);

            Console.WriteLine("================================");
            studentController.GetAllStudents();

        }
    }
}
