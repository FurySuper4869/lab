package cn.edu.xmu.restfuldemo.controller;

import cn.edu.xmu.restfuldemo.model.GoodsRetVo;
import cn.edu.xmu.restfuldemo.model.OrdersRetVo;
import cn.edu.xmu.restfuldemo.model.OrdersVo;
import cn.edu.xmu.restfuldemo.model.VoObject;
import cn.edu.xmu.restfuldemo.service.OrdersService;
import cn.edu.xmu.restfuldemo.util.ResponseCode;
import cn.edu.xmu.restfuldemo.util.ResponseUtil;
import cn.edu.xmu.restfuldemo.util.ReturnObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static cn.edu.xmu.restfuldemo.util.Common.getRetObject;
import static cn.edu.xmu.restfuldemo.util.Common.processFieldErrors;

@Api(value = "订单API", tags = "订单API")
@RestController /*Restful的Controller对象*/
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @ApiOperation(value = "获得一个订单对象",  produces="application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value ="订单对象id" ,required = true)
    })
    @ApiResponses({
    })
    @GetMapping("{id}")
    public Object getOrdersById(@PathVariable("id") Long id) {
        ReturnObject<VoObject> returnObject = ordersService.findById(id);
        ResponseCode code = returnObject.getCode();
        switch (code){
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }

    @ApiOperation(value = "新建订单",  produces="application/json")
    @ApiImplicitParams({
    })
    @ApiResponses({
    })
    @PostMapping("")
    public boolean createOrder(@Validated @RequestBody OrdersRetVo ordersRetVo){
        return ordersService.createOrders(ordersRetVo);
    }


    @GetMapping("1/{id}")
    public Object getOrdersById_Dao(@PathVariable("id") Long id) {
        ReturnObject<VoObject> returnObject = ordersService.findById_Dao(id);
        ResponseCode code = returnObject.getCode();
        switch (code){
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }

    @GetMapping("2/{id}")
    public Object getOrdersById_SQL(@PathVariable("id") Long id) {
        ReturnObject<VoObject> returnObject = ordersService.findById_SQL(id);
        ResponseCode code = returnObject.getCode();
        switch (code){
            case RESOURCE_ID_NOTEXIST:
                httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            case OK:
                OrdersRetVo ordersRetVo = (OrdersRetVo) returnObject.getData().createVo();
                return ResponseUtil.ok(ordersRetVo);
            default:
                return ResponseUtil.fail(code);
        }
    }
}

















