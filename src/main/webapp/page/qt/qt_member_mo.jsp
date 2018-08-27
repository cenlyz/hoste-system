<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="${basePath}css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${basePath}css/front.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/qianta.css">

<script src="${basePath}js/jquery-1.11.1.js"></script>
<script src="${basePath}js/jquery.min.js"></script>
<script src="${basePath}js/bootstrap.min.js"></script>
<script src="${basePath}qt_js/member_mo.js"></script>
	

 <div class="container denglukuang">
     <div class="modal" id="denglu">
        <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header modal_header">
                    <button type="button" class="close " data-dismiss="modal">
                     <span aria-hidden="true">&times;</span>
                     <span class="sr-only">会员</span>
                    </button>
                     <h3 align="center" style="color: white;">添加会员</h3>
                </div>
                <div class="modal-body">
                 <form id="moform" action="" method="post">
                    <table border="0" align="center" class="add_hy ">
                   
                        <tr class="modal_tr">
                        <td width="120px" class="td_hy">
                        	姓名：
                        </td>
                        <td>
                       		 <input placeholder="输入姓名" type="text" id="m_name" name="m_name" class="modal_input xm_name">
                        </td>
                        </tr>
                        <tr class="modal_tr">
                        <td class="td_hy">
                        	性别：
                        </td>
                        <td align="center">
                       		<p> <input type="radio" name="check_sex" checked="checked" class="modal_input xb_ra_input " value="F">男
                       		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       			 <input type="radio" name="check_sex" class="modal_input xb_ra_input" value="N">女
                       		 </p>
                        </td>
                        </tr>
                        <tr class="modal_tr">
                        <td class="td_hy">
                        	联系方法：
                        </td>
                        <td>
                       		 <input placeholder="输入联系方式" type="text" id="check_tel" name="check_tel" class="modal_input xm_name ">
                        </td>
                        </tr>
                        <tr class="modal_tr">
                        <td class="td_hy">
                        	身份证：
                        </td>
                        <td>
                       		 <input placeholder="输入18位身份证号码" type="text" name="id_number" id="id_number" class="modal_input xm_name">
                        </td>
                        </tr>
                         <tr class="modal_tr">
                        <td class="td_hy">
                        	预存金额：
                        </td>
                        <td align="center">
                             <input type="radio" name="m_price" id="m0" checked="checked" class="modal_input xb_ra_input" value="0">0元
                       		&nbsp; <input type="radio" name="m_price"  id="m1" class="modal_input xb_ra_input" value="1000">1000元
                       		 &nbsp;
                       		 <input type="radio" name="m_price" id="m2" class="modal_input xb_ra_input" value="5000">5000元
                        </td>
                        </tr>
                         <tr class="modal_tr">
                        <td class="td_hy">
                        	会员类型：
                        </td>
                        <td align="center">
                       		 <input type="text" disabled="disabled" name="m_type" value="普通vip" id="vip" class="modal_input xm_name">
                       		 
                        </td>
                        </tr>
                        <tr class="modal_tr">
                        <td class="td_hy">
                        	会员号：
                        </td>
                        <td>
                       		 <input placeholder="输入会员号" type="text" name="m_id" id="m_id" class="modal_input xm_name">
                        </td>
                        </tr>
                    </table>
                     </form>
                    <br/><br/>
                </div>
                <div class="modal-footer" id="modal-dialog-me">
			        <button type="button" class="btn btn-default off" data-dismiss="modal">取消</button>
			        <button type="button" class="btn btn-primary ok" >提交</button>
			      </div>
            </div>
        </div>
    </div>
   </div>
    