/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.lua.codeInsight.postfix.templates.editable;

import com.intellij.codeInsight.template.impl.TemplateImpl;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import com.intellij.codeInsight.template.postfix.templates.editable.EditablePostfixTemplate;
import com.intellij.codeInsight.template.postfix.templates.editable.EditablePostfixTemplateWithMultipleExpressions;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class LuaEditablePostfixTemplate extends EditablePostfixTemplateWithMultipleExpressions {


    protected LuaEditablePostfixTemplate(@NotNull String templateId, @NotNull String templateName, @NotNull TemplateImpl liveTemplate, @NotNull String example, @NotNull Set expressionConditions, boolean useTopmostExpression, @NotNull PostfixTemplateProvider provider) {
        super(templateId, templateName, liveTemplate, example, expressionConditions, useTopmostExpression, provider);
    }

    @Override
    protected List<PsiElement> getExpressions(@NotNull PsiElement context, @NotNull Document document, int offset) {
        return null;
    }

    @Override
    protected @NotNull PsiElement getTopmostExpression(@NotNull PsiElement element) {
        return null;
    }
}
