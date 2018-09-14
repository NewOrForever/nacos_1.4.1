/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.api.config.listener;

import java.util.concurrent.Executor;


/**
 * Listener for watch config
 * 
 * @author Nacos
 * 
 */
public interface Listener {

	/**
	 * Executor to excute this receive
	 * 
	 * @return Executor
	 */
    public Executor getExecutor();


    /**
     * 接收配置信息
     * 
     * @param configInfo 配置值
     */
    public void receiveConfigInfo(final String configInfo);
}