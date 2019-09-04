package com.leonard.anzwholesalecodingchallenge.controller;

import com.leonard.anzwholesalecodingchallenge.dto.AccountInfo;
import com.leonard.anzwholesalecodingchallenge.enums.AccountTypeEnum;
import com.leonard.anzwholesalecodingchallenge.enums.CurrencyEnum;
import com.leonard.anzwholesalecodingchallenge.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author limeng
 * @date 2019/9/4
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccountList() throws Exception {
        List<AccountInfo> accountInfoList = new ArrayList<>();
        AccountInfo accountInfo = AccountInfo.builder()
                .accountNumber(585309209)
                .accountName("SGSavings726")
                .accountType(AccountTypeEnum.SAVINGS.getValue())
                .balance(84327.51)
                .balanceDate(LocalDate.of(2019, 9, 4))
                .currency(CurrencyEnum.SGD.getValue())
                .build();
        accountInfoList.add(accountInfo);

        Mockito.when(accountService.getAccountList()).thenReturn(accountInfoList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[\n" +
                "    {\n" +
                "        \"accountNumber\": 585309209,\n" +
                "        \"accountName\": \"SGSavings726\",\n" +
                "        \"accountType\": \"Savings\",\n" +
                "        \"balanceDate\": \"2019-09-04\",\n" +
                "        \"currency\": \"SGD\",\n" +
                "        \"balance\": 84327.51\n" +
                "    }\n" +
                "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
    }

    @Test
    public void testAccountControllerWithEmptyList() throws Exception {
        List<AccountInfo> accountInfoList = new ArrayList<>();
        Mockito.when(accountService.getAccountList()).thenReturn(accountInfoList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
    }









}
