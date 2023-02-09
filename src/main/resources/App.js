function.ready(){
    var item, title, author, publisher, booklink, bookImg
    var outputlist = ducument.getElmentById("list-output");
    var bookUrl= "https://www.googleapis.com/books/v1/volumes?q="
    var placeHldr ='<img src="https://via.placeholder.com/150">'
    var searchData;

    $("#searche").click(function(){
            outputlist.innerHTML = ""
                    searchData=$("#search-box").val();
                    if(searchData === "" || searchData===null){
                    displayError();
            }
            else{
                $.ajax({
                url:bookUrl + searchData,
                dataType:"json",
            success: function(res){
                console.log(res)
            if(responce.totalItem === 0){
                alert("no results!");
            }
            else{
                $("title").anitem({'margin-top: 10px'});
                $("book-list").css('visibility: visible');
                displayResults(res);
            }
    }
            error: function(){
            alert("Something went wrong!")
            }
        })
    }
        $("#serach-box").val("");

    });
    function displayResults(res){
        for(var i = 0; i<res.item.length; i+=2)
        item = res.items[i];
        title1 = item.volumeInfo.title;
        author1 = item.volumeInfo.author;
        publisher1 = item.volumeInfo.publisher;
        bookIsbn = item.volumeInfo.industryIdentifiers[1].identifier
        bookImg1 =(item.volumeInfo.imageLinks)? item.volumeInfo.imageLinks.thumbnail:placeHldr;

        item2 = res.items[i+1];
                title2 = item2.volumeInfo.title;
                author2 = item2.volumeInfo.author;
                publisher2 = item2.volumeInfo.publisher;
                bookIsbn = item2.volumeInfo.industryIdentifiers[1].identifier
                bookImg2 =(item2.volumeInfo.imageLinks)? item2.volumeInfo.imageLinks.thumbnail:placeHldr;

                output-list.innerHTML += '<div class="row mt-4"' +
                                        formatOutput(bookImg1, title1, author1,publisher1,booklink1, bookIsbn)
                                        formatOutput(bookImg2, title2, author2,publisher2,booklink2, bookIsbn)
                                        '</div>'

    }
    function formatOutput(bookImg, title, author, publisher,booklink, bookIsbn ){
        var viewerUrl = 'book.html?isbn=' + bookIsbn;
        var htmlCard = '<div class ="col-lg-6>
                        <div class ="card-body">
                        <h5 class ="card-title">${title}</h5>
                        <p class ="card-text">Author:${author}</p>
                        <p class="card-text"> Publisher:{publisher}</p>
                        <a target"_blank" hrf ="${viewUrl" class = "btn btn-secondary">Ready Book</a>


                        </div>
        </div>'
        return htmlCard;
    }

}