if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready()
}

function ready() {
    

    var quantityInputs = document.getElementsByClassName('qty')
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i]
        input.addEventListener('change', quantityChanged)
    }

    
}


function quantityChanged(event) {
    var input = event.target
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1
    }
    updateCartTotal()
}



function updateCartTotal() {
    var cartItemContainer = document.getElementsByClassName('cart')[0]
    var cartRows = cartItemContainer.getElementsByClassName('cart1')
    var total = 0
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i]
        var priceElement = cartRow.getElementsByClassName('price')[0]
        var quantityElement = cartRow.getElementsByClassName('qty')[0]
        var price = parseFloat(priceElement.innerText)
        var quantity = quantityElement.value,
        total = total + (price * quantity)
        
    }
    total = Math.round(total * 100) / 100
    document.getElementsByClassName('cart-total-price')[0].innerText = total
}



