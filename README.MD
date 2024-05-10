# FINGER PRINT
## Description

Simple console app to generate labyrinth-like square pictures.<br>
Basic elements: **─, │, ┐, └, ┌, ┘,** -empty cell-

Elements are selected randomly.<br>
Main rule is - no free ends.<br>

## Commands

#### -Number-<br>

Prints any positive integer to get picture of the specified size. <br>

#### d<br>

Sets line style to double. 

#### r<br>

Sets line style to round.

#### q<br>

Quits app.

## Examples
```
2
┌┐
└┘
3
┌─┐
│ │
└─┘
4
┌┐┌┐ ┌──┐ ┌──┐ ┌──┐ ┌──┐ ┌┐┌┐ ┌─┐ 
│└┘│ └┐┌┘ │┌┐│ └─┐│ │┌─┘ ││││ └┐└┐
│┌┐│ ┌┘└┐ │└┘│ ┌─┘│ │└─┐ │└┘│ ┌┘┌┘
└┘└┘ └──┘ └──┘ └──┘ └──┘ └──┘ └─┘ 
5
┌─┐┌┐ ┌┐┌┐ ┌┐┌─┐ ┌┐┌┐ 
└┐└┘│ ││└┘ │││┌┘ │└┘│ 
┌┘┌─┘ └┘┌┐ │││└┐ └┐┌┘ 
│ └─┐ ┌┐││ │└┘┌┘ ┌┘└┐ 
└───┘ └┘└┘ └──┘  └──┘ 
6
┌─┐┌─┐ ┌┐┌┐┌┐ 
│┌┘│┌┘ └┘││││ 
│└─┘└┐ ┌─┘│└┘ 
│┌┐┌┐│ │┌─┘┌┐ 
│││└┘│ ││┌─┘│ 
└┘└──┘ └┘└──┘ 
10
┌──┐┌┐┌┐┌┐ ╔╗╔╗╔═╗╔╗  ╭─╮╭────╮ 
│┌┐└┘│└┘└┘ ╚╝╚╝╚═╝╚╝  ╰─╯╰─╮╭╮╰╮
│└┘┌┐└─┐┌┐ ╔╗╔══╗╔═╗  ╭╮╭╮╭╯││╭╯
└─┐│└──┘└┘ ╚╝║╔╗║║╔╝  │╰╯╰╯╭╯╰╯ 
┌┐││┌┐┌──┐ ╔╗║║║║╚╝╔╗ │╭╮╭─╯╭──╮
│└┘│└┘└─┐│ ╚╝╚╝║║╔╗╚╝ ││╰╯╭╮│╭╮│
└──┘┌─┐┌┘│ ╔═══╝╚╝║╔╗ ││╭─╯╰╯│╰╯
┌┐┌─┘┌┘└─┘ ║╔╗╔╗╔╗╚╝║ │╰╯╭──╮│╭╮
│││┌┐└┐┌─┐ ║╚╝║║║╚╗╔╝ ╰─╮╰──╯╰╯│
└┘└┘└─┘└─┘ ╚══╝╚╝ ╚╝    ╰──────╯
```
