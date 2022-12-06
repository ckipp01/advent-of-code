# My Notes

I've really struggled with algorithms in the past. I'm definitely not someone
who this comes "easy" to or "thinks in this way". However, I think it's
important to practice and I believe it's something we can get better at with
practice. My goal is to attempt to finish these without looking at other
answers, and then dig into other solutions. I'll leave my implementations there,
but add notes here about how I could have done it better.

## Day 1

I ended up using recursion here and after looking at other solutions a friend of
mine told me:

> never recurse when there is unfold to the rescue :P

I didn't really think of `unfold` and rarely use it, but this would have indeed
been nice to use here. I'll try to use it later on.

## Day 2

I struggled trying to use Scala 3 `enum`s here. However I still feel like that
could have been nice, but I didn't spend the time doing it. I went with the
approach of just writing everything out manually instead of any fancy modulo
stuff since I figured there was only 9 cases and it's easy to read.

## Day 3

Ha, so I finally used `unfold` here but made other mistakes. I totally forgot
that `intersect` was even a thing and instead stupidly did it myself.

## Day 4

So this one was pretty easy, but I did get a bit confused at `Range#contains`:

```scala
import scala.collection.immutable.Range.Inclusive

val a = Range(1, 3).inclusive
// a: Range = Range 1 to 3
val b = Range(2, 3).inclusive
// b: Range = Range 2 to 3

a.size
// res0: Int = 3
b.size
// res1: Int = 2

a.contains(b.start)
// res2: Boolean = true
a.contains(b.end)
// res3: Boolean = true
a.contains(b)
// res4: Boolean = false
```

For example my brain right away though `a.contains(b)` should have been true
here, but that's not right. Looking into the implementation it makes sense, but
I'm sure this bites people.

## Day 5

This one took me quite a bit longer to figure out the parsing. I have never used
`transpose` here before so I was happy to learn this.

## Day 6

This was sort of troll lol, but for some reason a queue came into my head and I
wanted to use that. I could do this way simpler like:

```scala
getLines("6.txt").head
  .sliding(distinctCount)
  .indexWhere(_.toSet.size == distinctCount) + distinctCount
```
