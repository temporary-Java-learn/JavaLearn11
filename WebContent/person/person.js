<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <h1 class="mui-title">通讯录管理</h1>
</header>
<div class="mui-content mui-content-padded">
    <button type="button" id="btnAddContac" class="mui-btn mui-btn-blue mui-btn-block">添加联系人</button>
    <button type="button" id="btnDelContact" class="mui-btn mui-btn-blue mui-btn-block">删除联系人</button>
    <button type="button" id="btnSearchContact" class="mui-btn mui-btn-blue mui-btn-block">查找联系人</button>
    <button type="button" id="btnModifyContact" class="mui-btn mui-btn-blue mui-btn-block">修改联系人</button>
</div>
<script src='http://libs.baidu.com/jquery/1.8.3/jquery.min.js'></script>
<script src="js/mui.min.js"></script>
<script type="text/javascript">
mui.plusReady(function(){
    var addressBookObj = null;
    // 保证我们的addressBookObj 对象是存在的
    plus.contacts.getAddressBook(plus.contacts.ADDRESSBOOK_PHONE,function(addressBook){
        addressBookObj = addressBook;
        // 添加联系人
        $("#btnAddContac").bind('tap',function(){
            plus.contacts.getAddressBook(plus.contacts.ADDRESSBOOK_PHONE,function(addressBook){
            var contact = addressBookObj.create();
            contact.name = {givenName:'张三'};
            contact.phoneNumbers = {type:"手机",value:"1388888888",preferred:true};
            contact.save();
            mui.alert('添加成功');
            },function(){});
        });
        // 查找联系人
        $("#btnModifyContact").bind('tap',function(){
            addressBookObj.find("",function(contacs){
                //alert(contacs);
                for(var i=0;i<contacs.length;++i){
                    alert(contacs[i].name.givenName);
                };
            },function(e){
                console.log(e.message);
            },{filter:[{logic:'and',field:'givenName',value:'*张*'}]});
        });
        // 修改联系人
        $("#btnModifyContact").bind('tap',function(){
            addressBookObj.find("",function(contacs){
                //alert(contacs);
                for(var i=0;i<contacs.length;++i){
                    contacs[i].name.givenName ="李四";
                    contacs[i].save();
                };
                mui.alert("修改成功");
            },function(e){
                console.log(e.message);
            },{filter:[{logic:'and',field:'givenName',value:'*张*'}]});
        });
        // 删除联系人
        $("#btnDelContact").bind('tap',function(){
            addressBookObj.find("",function(contacs){
                //alert(contacs);
                for(var i=0;i<contacs.length;++i){
                    contacs[i].remove();
                };
                mui.alert("删除成功");
            },function(e){
                console.log(e.message);
            },{filter:[{logic:'and',field:'givenName',value:'*李四*'}]});
        });
    },function(){});    
});
</script>