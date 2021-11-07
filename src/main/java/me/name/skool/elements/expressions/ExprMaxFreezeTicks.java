package me.name.skool.elements.expressions;

import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.expressions.base.SimplePropertyExpression;

public class ExprMaxFreezeTicks extends SimplePropertyExpression<LivingEntity, Integer> {

    static {
        register(ExprMaxFreezeTicks.class, Integer.class, "max[imum] freeze ticks", "livingentities");
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    @Override
    @Nullable
    public Integer convert(LivingEntity e) {
        return e.getMaxFreezeTicks();
    }

    @Override
    protected String getPropertyName() {
        return "max[imum] freeze ticks";
    }
}