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

import com.intellij.codeInsight.template.postfix.templates.editable.PostfixTemplateExpressionCondition;
import com.tang.intellij.lua.psi.LuaTypeGuessable;
import com.tang.intellij.lua.search.SearchContext;
import com.tang.intellij.lua.ty.TyKind;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public interface LuaPostfixTemplateExpressionCondition extends PostfixTemplateExpressionCondition<LuaTypeGuessable> {

    class LuaPostfixTemplateExpressionValueCondition implements LuaPostfixTemplateExpressionCondition {
        public static final @NonNls String ID = "value";

        @Override
        public @NotNull @Nls String getPresentableName() {
            return "value";
        }

        @Override
        public @NotNull @NonNls String getId() {
            return ID;
        }

        @Override
        public boolean value(@NotNull LuaTypeGuessable luaTypeGuessable) {
            switch (luaTypeGuessable.guessType(SearchContext.Companion.get(luaTypeGuessable.getProject())).getKind()) {
                case Function, Void -> {
                    return false;
                }
                default -> {
                    return true;
                }
            }
        }
    }

    class LuaPostfixTemplateExpressionFunctionCondition implements LuaPostfixTemplateExpressionCondition {
        public static final @NonNls String ID = "function";

        @Override
        public @NotNull @Nls String getPresentableName() {
            return "function";
        }

        @Override
        public @NotNull @NonNls String getId() {
            return ID;
        }

        @Override
        public boolean value(@NotNull LuaTypeGuessable luaTypeGuessable) {
            return luaTypeGuessable.guessType(SearchContext.Companion.get(luaTypeGuessable.getProject())).getKind() == TyKind.Function;
        }
    }

}
