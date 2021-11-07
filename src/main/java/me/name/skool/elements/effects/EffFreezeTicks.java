package me.name.skool.elements.effects;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffFreezeTicks extends Effect {

    static {
        Skript.registerEffect(EffFreezeTicks.class, "(set|make) freeze ticks (of|for) %livingentity% to %integer%");
    }

    private Expression<LivingEntity> subject;
    private Expression<Integer> ticks;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.subject = (Expression<LivingEntity>) expressions[0];
        this.ticks = (Expression<Integer>) expressions[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "Set Freeze Ticks of Entity: " + subject.toString(event, debug) + " to: " + ticks.toString(event, debug);
    }

    @Override
    protected void execute(Event event) {
        if (subject == null)  return;
        if (ticks == null) return;
        subject.getSingle(event).setFreezeTicks(ticks.getSingle(event));
    }
}
