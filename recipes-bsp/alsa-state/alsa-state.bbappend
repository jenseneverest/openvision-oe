FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH := "${MACHINE_ARCH}"

EXTRA_ALSA ?= "normal"

EXTRA_ALSA_odroidc2 = "amls905"
EXTRA_ALSA_wetekplay2 = "amls905"
EXTRA_ALSA_wetekhub = "amls905"

EXTRA_ALSA_alien5 = "aml905d"
EXTRA_ALSA_k1plus = "aml905d"
EXTRA_ALSA_k1pro = "aml905d"
EXTRA_ALSA_k2pro = "aml905d"
EXTRA_ALSA_k2prov2 = "aml905d"
EXTRA_ALSA_k3pro = "aml905d"

EXTRA_ALSA_wetekplay = "aml8726"
EXTRA_ALSA_x8hp = "aml8726"

require alsa-state-${EXTRA_ALSA}.inc
