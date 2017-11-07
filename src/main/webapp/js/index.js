$(function () {
    //点击返回顶部
    $(window).scroll(function() {
        if($(window).scrollTop() > 600) {
            $('.backTop').stop().fadeIn(100) //stop停止所有动画
        } else {
            $('.backTop').stop().fadeOut(100)
        }
    });
    $('.backTop').unbind('click').click(function() {
        $('body,html').animate({ //动画效果
            scrollTop: 0
        }, 200);
    });

});

// 主页 鼠标移动到头像模块，面板显示
window.onload=function(){
    var t;
    document.getElementById("user_head").onmouseover=function(){
        document.getElementById("userInfo").style.display = 'block'
    };
    document.getElementById("user_head").onmouseout=function(){
        t = setTimeout("document.getElementById('userInfo').style.display = 'none'",2000);
    };
    document.getElementById("userInfo").onmouseover=function(){
        document.getElementById("userInfo").style.display = 'block';
        clearTimeout(t);
    };
    document.getElementById("userInfo").onmouseout=function(){
        document.getElementById("userInfo").style.display = 'none'
    };

}



