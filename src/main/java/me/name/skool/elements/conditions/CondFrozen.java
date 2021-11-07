package me.name.skool.elements.conditions;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class CondFrozen extends Condition {

    static {
        Skript.registerCondition(CondFrozen.class, "%livingentity% (1¦is|2¦is(n't| not)) frozen");
    }

    Expression<LivingEntity> entity;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.entity = (Expression<LivingEntity>) expressions[0];
        setNegated(parser.mark == 1);
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Entity: " + entity.toString(event, debug);
    }

    @Override
    public boolean check(Event event) {
        LivingEntity e = entity.getSingle(event);
        if (e == null) return isNegated();
        return e.isFrozen() == isNegated();
    }

}