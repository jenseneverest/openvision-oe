FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_ALSA ?= "normal"

require alsa-state-${EXTRA_ALSA}.inc
