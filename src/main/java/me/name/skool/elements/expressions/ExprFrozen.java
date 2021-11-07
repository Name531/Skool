package me.name.skool.elements.expressions;

import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.expressions.base.SimplePropertyExpression;

public class ExprFrozen extends SimplePropertyExpression<LivingEntity, Boolean> {

    static {
        register(ExprFrozen.class, Boolean.class, "frozen state", "livingentity");
    }

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    @Override
    @Nullable
    public Boolean convert(LivingEntity e) {
        return e.isFrozen();
    }

    @Override
    protected String getPropertyName() {
        return "frozen state";
    }
}