if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()
}

function ready() {

updateCartTotal();

}
function updateCartTotal() {
    var cartRows = document.getElementsByClassName('cart')
    console.log(cartRows.length)
    var total =0;
    
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        console.log(cartRow)
        var priceElement = cartRow.getElementsByClassName('price')[i]
        var quantityElement = cartRow.getElementsByClassName('qty')[i]
        
        var price = parseFloat(priceElement.innerText)
        console.log(price)
        var quantity = quantityElement.value,
        
        subtotalPrice = price * quantity
        cartRow.getElementsByClassName('subTotal')[i].innerText = subtotalPrice
        console.log(subtotalPrice)
        
    }
    
}

      



