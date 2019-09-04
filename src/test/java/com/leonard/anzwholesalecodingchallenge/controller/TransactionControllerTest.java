package com.leonard.anzwholesalecodingchallenge.controller;

import com.leonard.anzwholesalecodingchallenge.dto.TransactionInfo;
import com.leonard.anzwholesalecodingchallenge.enums.CurrencyEnum;
import com.leonard.anzwholesalecodingchallenge.enums.TransactionTypeEnum;
import com.leonard.anzwholesalecodingchallenge.service.TransactionService;
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
@WebMvcTest(value = TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void testGetTransactionList() throws Exception {
        List<TransactionInfo> transactionInfoList = new ArrayList<>();
        TransactionInfo transactionInfo = TransactionInfo.builder()
                .accountNumber(585309209)
                .accountName("SGSavings726")
                .valueDate(LocalDate.of(2018, 11, 8))
                .currency(CurrencyEnum.SGD.getValue())
                .debitAmount((double) 0)
                .creditAmount(9540.98)
                .transactionType(TransactionTypeEnum.CREDIT.getValue())
                .transactionNarrative("")
                .build();
        transactionInfoList.add(transactionInfo);

        Mockito.when(transactionService.getTransactionListByAccountNumber(585309209)).thenReturn(transactionInfoList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transaction/585309209");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[\n" +
                "    {\n" +
                "        \"accountNumber\": 585309209,\n" +
                "        \"accountName\": \"SGSavings726\",\n" +
                "        \"valueDate\": \"2018-11-08\",\n" +
                "        \"currency\": \"SGD\",\n" +
                "        \"debitAmount\": 0,\n" +
                "        \"creditAmount\": 9540.98,\n" +
                "        \"transactionType\": \"Credit\",\n" +
                "        \"transactionNarrative\": \"\"\n" +
                "    }\n" +
                "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void testTransactionControllerWithEmptyList() throws Exception {
        List<TransactionInfo> transactionInfoList = new ArrayList<>();
        Mockito.when(transactionService.getTransactionListByAccountNumber(585309209)).thenReturn(transactionInfoList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transaction/585309209");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
    }

}
