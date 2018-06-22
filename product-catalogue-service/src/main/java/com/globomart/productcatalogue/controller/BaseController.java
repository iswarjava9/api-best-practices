/**
 * @author Iswar
 */

package com.globomart.productcatalogue.controller;

import javax.annotation.Resource;

import com.globomart.productcatalogue.util.ConverterUtil;

public class BaseController {
	@Resource
	protected ConverterUtil converterUtil;
}
