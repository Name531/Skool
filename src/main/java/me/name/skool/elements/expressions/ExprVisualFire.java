package me.name.skool.elements.expressions;

import ch.njol.skript.classes.Changer.ChangeMode;
import org.bukkit.event.Event;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.expressions.base.SimplePropertyExpression;

public class ExprVisualFire extends SimplePropertyExpression<LivingEntity, Boolean> {

    static {
        register(ExprVisualFire.class, Boolean.class, "visual fire [state]", "livingentities");
    }

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    @Override
    @Nullable
    public Boolean convert(LivingEntity e) {
        return e.isVisualFire();
    }

    @Override
    protected String getPropertyName() {
        return "visual fire [state]";
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        if (delta != null) {
            Boolean val = (Boolean) delta[0];
            for (LivingEntity ent : getExpr().getArray(event)) {
                ent.setVisualFire(val);
            }
        } else {
            for (LivingEntity ent : getExpr().getArray(event)) {
                ent.setVisualFire(false);
            }
        }
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode) {
        return (mode == ChangeMode.SET || mode == ChangeMode.RESET || mode == ChangeMode.DELETE) ? new Class[] {Boolean.class} : null;
    }
}