FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH := "${MACHINE_ARCH}"

EXTRA_ALSA ?= "normal"

EXTRA_ALSA_vuduo4k = "vuplus"
EXTRA_ALSA_vusolo4k = "vuplus"
EXTRA_ALSA_vuultimo4k = "vuplus"
EXTRA_ALSA_vuuno4k = "vuplus"
EXTRA_ALSA_vuuno4kse = "vuplus"
EXTRA_ALSA_vuzero4k = "vuplus"
EXTRA_ALSA_vuduo2 = "vuplus"
EXTRA_ALSA_vusolo2 = "vuplus"
EXTRA_ALSA_vusolose = "vuplus"

EXTRA_ALSA_odroidc2 = "amls905"
EXTRA_ALSA_wetekplay2 = "amls905"
EXTRA_ALSA_wetekhub = "amls905"

EXTRA_ALSA_alien5 = "aml905d"
EXTRA_ALSA_alien4 = "aml905d"
EXTRA_ALSA_c300 = "aml905d"
EXTRA_ALSA_c300pro = "aml905d"
EXTRA_ALSA_c400plus = "aml905d"
EXTRA_ALSA_k1plus = "aml905d"
EXTRA_ALSA_k1pro = "aml905d"
EXTRA_ALSA_k2pro = "aml905d"
EXTRA_ALSA_k2prov2 = "aml905d"
EXTRA_ALSA_k3pro = "aml905d"
EXTRA_ALSA_kvim2 = "aml905d"

EXTRA_ALSA_wetekplay = "aml8726"
EXTRA_ALSA_x8hp = "aml8726"

require alsa-state-${EXTRA_ALSA}.inc
