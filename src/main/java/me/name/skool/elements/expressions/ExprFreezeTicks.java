package me.name.skool.elements.expressions;

import ch.njol.skript.classes.Changer.ChangeMode;
import org.bukkit.event.Event;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.expressions.base.SimplePropertyExpression;

public class ExprFreezeTicks extends SimplePropertyExpression<LivingEntity, Integer> {

    static {
        register(ExprFreezeTicks.class, Integer.class, "freeze ticks", "livingentities");
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    @Override
    @Nullable
    public Integer convert(LivingEntity e) {
        return e.getFreezeTicks();
    }

    @Override
    protected String getPropertyName() {
        return "freeze ticks";
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        if (delta != null) {
            int val = (int) delta[0];
            if (mode == ChangeMode.ADD) {
                for (LivingEntity ent : getExpr().getArray(event)) {
                    ent.setFreezeTicks(ent.getFreezeTicks() + val);
                }
            }
            if (mode == ChangeMode.SET) {
                for (LivingEntity ent : getExpr().getArray(event)) {
                    ent.setFreezeTicks(val);
                }
            }
            if (mode == ChangeMode.REMOVE) {
                for (LivingEntity ent : getExpr().getArray(event)) {
                    ent.setFreezeTicks(ent.getFreezeTicks() - val);
                }
            }
        } else {
            if (mode == ChangeMode.RESET || mode == ChangeMode.DELETE) {
                for(LivingEntity ent : getExpr().getArray(event)) {
                    ent.setFreezeTicks(0);
                }
            }
        }
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode) {
        return (mode != ChangeMode.REMOVE_ALL) ? new Class[] {Integer.class} : null;
    }
}