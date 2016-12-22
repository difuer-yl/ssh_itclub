$('#hd_nav >ul >li').on('click',function(){
    $('#hd_nav >ul> .active').removeClass('active');
    $(this).addClass('active');
});
{
    var a=document.URL.split('/');
    var b=a[a.length-1];
//    alert(b);
//    alert($("li")[3]);
   $("."+b).addClass("active");
}