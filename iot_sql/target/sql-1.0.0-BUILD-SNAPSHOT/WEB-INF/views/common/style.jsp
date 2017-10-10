<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>	
	@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
	*{margin:0; padding:0; border:none;}
	#tabstrip-parent,
    #tabstrip {
      height: 100%;
      margin: 0;
      padding: 0;
      border-width: 0;
    }
	body{font-family: 'Jeju Gothic', serif;}
	nav{
		position:relative;
		width:100%;
		height:54px;
		border-bottom:0;
	}	
	nav.navbar{
		margin-bottom:0;		
	}
	.navbar-nav{
		float:right;	
	}	
	.container{
		width:100%;
		height:54px;
		background-color:#333;
		border-bottom:2px solid #3f9d8f;
	}		
	#navbar ul li:last-child{
		position:absolute;
		right:0;
	}
	#navbar ul li a{
		font-size:15px;
	}
	#navbar ul li a:hover{
		transition:0.3s;
		color:#3f9d8f;		
	}
	 
	.navbar-brand {
		background:url("${imgUrl}home_1.png")no-repeat center;
		text-indent:-9999px;
		width:50px;		
	}
	.navbar-brand:hover{
		background:url("${imgUrl}home_2.png")no-repeat center;				
	}
	p{
		width:0;
		height:0;
	}	
    #vertical {
    	position:relative;
    	width:100%;
        height: 893px;
        top:31px;
    }
    #middle-pane { 
        color: #000; background-color: #fff; 
    }

    #bottom-pane { 
        color: #000; background-color: #fff; 
    }
    #left-pane{
    	width:233px;
    }
    #left-pane .pane-content {
    	width:100%; 
    	border:none;
    }
    #toolbar {
        width:100%;
        background-color:#3f9d8f;
    }
    .k-button.k-state-active:hover, .k-button:active:hover{
    	background-color:#42372e;
    	box-shadow:inset 0 0 3px 1px #3b2f2a;
    }
    .k-button:focus:active:not(.k-state-disabled):not([disabled]){
    	background-color:#42372e;
    	box-shadow:inset 0 0 3px 1px #3b2f2a;
    }
    .k-state-selected.k-state-focused{
    	background-color:#3f9d8f;
    	box-shadow:inset 0 0 3px 1px #3d8b97;
    	-webkit-box-shadow:inset 0 0 3px 1px #3d8b97;
    }        
    .k-state-selected{
    	background-color:#3f9d8f;
    	box-shadow:0 0 3px 1px  #3d8b97;
    	-webkit-box-shadow:0 0 3px 1px #3d8b97;
    }
    .k-header.k-state-focused{
    	background-color:#3d8b97;
    	color:#fff;
    }
    .k-header .k-sorted .k-state-focused{
    	border-color:#3d8b97;
    }    
    #btnConnect{
    	position:relative;
    	margin:6px 0 0 8px;
    } 
    
   
    .k-state-selected{
    	border-color:#3d8b97;
    }
    .user-image {
        margin: 0 .5em;
    }
    #example {
        height: 500px;
    }
    #example .box p {
        padding-bottom: 5px;
    }
    .k-grid-content{
    	overflow:auto;
    }
    #content .demo-section {
        margin: 0;
        padding: 10px;
        border-width: 0 0 1px 0;
    }
    #content .demo-section label {
        display: inline-block;
        width: 40px;
        text-align: right;
        line-height: 2.5em;
        vertical-align: middle;
    }   
    #middle-pane>.pane-content >h3{
    	margin:10px 0 0 10px;
    }    
    #middle-pane>.pane-content >p{
    	margin:10px 0 0 10px;
    }    
	#bottom-pane.k-pane{		
		background-color:red;	
		color:#fff;
		text-align:center;		
		border:none;
		font-size:12px;
		line-height:10px;
	}	
	.k-splitbar{
		border-color:#e9e9e9;		
	}
	.k-splitter .k-scrollable{
		overflow:hidden;
	}	
	#tabStrip > ul >li:last-child span{
		background:url("${imgUrl}pen.png")no-repeat center;
		text-indent:-9999px;
	}
	@media screen and (min-width: 768px){
		.navbar-nav{float:left;}
	}
	.k-tabstrip>.k-content{
		padding:0;
	}
	#tabStrip-1{
		height:90%;
	}
	#tabStrip-2{
		height:90%;
	}
	.pane-content{
		height:100%;
	}
	.k-tabstrip-wrapper{
		height:100%;
	}
	.k-grid-content{
		overflow-x: auto;
   		overflow-y: scroll;
	}
	.k-tabstrip>.k-content{
		overflow:hidden;
	}
	.weather{
		position:relative;
		width:100%;
		height:100%;
	}
	#tableInfoGrid{
		height:100%;
	}
	#btnRun{
		position:absolute;
		left:5px;		
		top:7px;
	}
	#queryToolbar{
		position:relative;
	}
	#query{
		position:absolute;
		left:0;	
		margin:10px;		
		width:98%;
		height:80%;
	}
	
	#tabStrip {
	width: 100%;
	height: 100%
	}
	
	.sunny, .cloudy, .rainy {
		margin: 30px auto 10px;
		width: 100%;
		height: 128px;
	}
	
	.weather {
		margin: 0 auto 30px;
		text-align: center;
	}
	
	#tabstrip h2 {
		font-weight: lighter;
		font-size: 5em;
		line-height: 1;
		padding: 0 0 0 30px;
		margin: 0;
	}
	
	#tabstrip h2 span {
		background: none;
		padding-left: 5px;
		font-size: .3em;
		vertical-align: top;
	}
	
	#tabstrip p {
		margin: 0;
		padding: 0;
	}
</style>



