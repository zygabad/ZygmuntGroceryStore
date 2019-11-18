package com.zygstore.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static java.lang.System.out;

import com.zygstore.dto.CategoryDTO;
import com.zygstore.dto.ProductDTO;
import com.zygstore.excpetions.WrongFileFormatExcetion;
import com.zygstore.navigation.Result;
import com.zygstore.service.CategoryService;
import com.zygstore.service.ProductService;
import com.zygstore.utils.ReadKomputronikSite;
import com.zygstore.utils.WriteFileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@ManagedBean(name = "adminCacheBean", eager = true)
@SessionScoped
public class AdminCacheBean {
    private static final Logger LOGGER = Logger.getLogger(AdminCacheBean.class);

    CacheManager cacheManager;

    public AdminCacheBean(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        out.println("AdminCacheBean zainicjalizowany !");
        LOGGER.info("AdminCacheBean initialized!");
    }

    public Result clearCache() {
        cacheManager.getCache("categories").clear();
        showMessage();

        return Result.CACHE_CLEAR_SUCCESS;
    }

    protected void showMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO Message", "INFO Cache was successfully cleared"));
        LOGGER.info("Cache was successfully cleared");
    }

}
