using Exam.Entities;
using System.ComponentModel.DataAnnotations;

namespace Exam.Models
{
    public class DepartmentCreateModel
    {

        [Required]
        public required string DepartmentName { get; set; }

        [Required]
        public required string DepartmentCode { get; set; }

        [Required]
        public required string Location { get; set; }
    }
}