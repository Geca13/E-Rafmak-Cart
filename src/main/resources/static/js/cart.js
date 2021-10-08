$(document).ready(function() {
   
   $(".minus").on("click", function(evt) {
     evt.preventDefault();
     decreaseQuantity($(this));
   }
   
   $(".plus").on("click", function(evt) {
     evt.preventDefault();
     increaseQuantity($(this));
   }
   
   updateTotal();
});

function updateTotal() {
   total = 0.0;
   
   $(".subTotal").each(function(index, element) {
      total = total + parseFloat(element.innerHTML)
   });
   
   $("#total").text(total);
}

